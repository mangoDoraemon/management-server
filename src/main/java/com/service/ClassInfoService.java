package com.service;

import com.entity.ClassInfo;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/21 17:41
 */
public interface ClassInfoService {
    PageInfo fetchData(Integer page, Integer limit, String fuzzy, String classCode, String className);

    AjaxResult addData(ClassInfo classInfo, HttpServletRequest request);

    AjaxResult deleteData(String id);

    AjaxResult updateData(ClassInfo classInfo,HttpServletRequest request);
}
