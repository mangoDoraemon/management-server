package com.controller;

import com.dao.UserInfoMapper;
import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.util.AjaxResult;
import com.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 15:52
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 用户登陆
     * @param user
     * @param request
     * @return
     */
    @PutMapping("/login")
    public AjaxResult login(@RequestBody UserInfo user, HttpServletRequest request){
        return userService.login(user.getUserName(), user.getUserPassword(), request);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody UserInfo user){
        return userService.register(user);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @param request
     * @return
     */
    @PutMapping("/modify")
    public AjaxResult modify(@RequestBody UserInfo userInfo,HttpServletRequest request){
        return userService.modify(userInfo,request);
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

    /**
     * 查询用户信息
     * @param page
     * @param limit
     * @param fuzzy
     * @param userName
     * @param authId
     * @return
     */
    @GetMapping("/fetchUser")
    public PageInfo fetchUserInfoData(
            @RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                                         @RequestParam(required = false) String userName, @RequestParam(required = false) String authId
    ){
        return userService.fetchUserInfoData(page,limit,fuzzy,userName,authId);
    }

    @GetMapping ("/exportUser")
    public AjaxResult exportUser(){
        UserInfo userInfo = new UserInfo();
        List<UserInfo> list = userInfoMapper.selectUserInfoAll(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        AjaxResult ajaxResult=util.exportExcel(list, "userData");
        return ajaxResult;
    }

    @DeleteMapping("/deleteUser/{id}")
    public AjaxResult deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }

    /**
     * 修改个人信息
     * @param userInfo
     * @param request
     * @return
     */
    @PutMapping("/modifyOwn")
    public AjaxResult modifyOwn(@RequestBody UserInfo userInfo,HttpServletRequest request){
        return userService.modifyOwn(userInfo,request);
    }
}
