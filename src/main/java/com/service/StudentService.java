package com.service;

import com.entity.Student;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:05
 */
public interface StudentService {
    PageInfo selectStudentInfoData(Integer page, Integer limit, String fuzzy, String studentNumber, String studentName);

    AjaxResult addStudentInfo(Student student);

    AjaxResult deleteStudent(String id);

    AjaxResult updateStudent(Student student);

    PageInfo fetchSubject(Integer page, Integer limit, String fuzzy, HttpServletRequest request);

    AjaxResult chooseSubject(String id, HttpServletRequest request);
}
