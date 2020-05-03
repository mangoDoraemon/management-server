package com.service;

import com.entity.Student;
import com.entity.Subject;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:13
 */
public interface SubjectService {

    AjaxResult addAndUpdateData(Subject subject, HttpServletRequest request);

    PageInfo fetchOwnData(Integer page, Integer limit, String fuzzy, HttpServletRequest request);

    AjaxResult fetchDataById(String id);

    AjaxResult fetchTree(HttpServletRequest request);

    AjaxResult fetchMineStudent(String id, HttpServletRequest request);

    AjaxResult deleteMineStudent(String id, HttpServletRequest request);

    AjaxResult updateMineStudent(Student student, HttpServletRequest request);
}
