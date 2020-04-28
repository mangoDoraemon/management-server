package com.interceptor;


import com.alibaba.fastjson.JSON;
import com.annotaion.LoginRequired;
import com.constant.CommonConstant;
import com.controller.CommonController;
import com.util.AjaxResult;
import com.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Method;


/**
 * @author Administrator
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(LoginRequired.class)) {
            return true;
        }else {
            HttpSession httpSession = httpServletRequest.getSession();
            if(!StringUtils.isEmpty((CharSequence) httpSession.getAttribute(CommonConstant.SESSION_USER_ID))){
                return true;
            }else {
                httpServletResponse.reset();
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setHeader("Cache-Control", "no-store");
                httpServletResponse.setCharacterEncoding("UTF-8");
                PrintWriter pw = httpServletResponse.getWriter();
                pw.write(JSON.toJSONString(AjaxResult.warn("session过期")));
                pw.flush();
                   logger.info("请求已经被拦截");
                   return false;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
