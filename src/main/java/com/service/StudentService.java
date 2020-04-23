package com.service;

import com.entity.Student;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:05
 */
public interface StudentService {
    PageInfo selectStudentInfoData(Integer page, Integer limit, String fuzzy, String studentNumber, String studentName);

    AjaxResult addStudentInfo(Student student);

    AjaxResult deleteStudent(String id);

    AjaxResult updateStudent(Student student);
}
