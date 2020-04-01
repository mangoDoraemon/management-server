package com.controller;

import com.entity.UserInfo;
import com.service.UserService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 15:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登陆
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/login")
    public UserInfo login(@RequestBody UserInfo user, HttpServletRequest request){
        return userService.login(user.getUserName(), user.getUserPassword(), request);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/user")
    public AjaxResult register(@RequestBody UserInfo user){

        return userService.register(user);
    }

    /**
     * 用户退出
     * @param request
     */
    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        userService.logout(request);
    }

    /**
     * token验证
     * @param token
     * @return
     */
    @GetMapping("/token")
    public UserInfo getInfoByToken(@RequestParam String token){
        return userService.getUserInfoByToken(token);
    }
}
