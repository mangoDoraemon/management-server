package com.service;

import com.entity.UserInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 16:23
 */
public interface UserService {
    UserInfo login(String userName, String userPassword, HttpServletRequest request);

    AjaxResult register(UserInfo user);

    void logout(HttpServletRequest request);

    UserInfo getUserInfoByToken(String token);
}
