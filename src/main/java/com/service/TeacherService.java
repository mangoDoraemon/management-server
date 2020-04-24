package com.service;

import com.entity.Teacher;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:06
 */
public interface TeacherService {
    PageInfo fetchData(Integer page, Integer limit, String fuzzy, String teacherNumber, String teacherName);

    AjaxResult addData(Teacher teacher);

    AjaxResult updateData(Teacher teacher);

    AjaxResult deleteData(String id);
}
