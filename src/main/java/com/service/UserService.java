package com.service;

import com.entity.UserInfo;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 16:23
 */
public interface UserService {
    AjaxResult login(String userName, String userPassword, HttpServletRequest request);

    AjaxResult register(UserInfo user);

    void logout(HttpServletRequest request);

    UserInfo getUserInfoByToken(String token);

    AjaxResult modify(UserInfo userInfo, HttpServletRequest request);

    PageInfo fetchUserInfoData(Integer page, Integer limit, String fuzzy, String userName, String authId);
}
