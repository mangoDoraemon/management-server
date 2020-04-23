package com.service;

import com.entity.College;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:14
 */
public interface CollegeService {
    PageInfo fetchData(Integer page, Integer limit, String fuzzy, String collegeCode, String collegeName);

    AjaxResult addData(College college);

    AjaxResult updateData(College college);

    AjaxResult deleteData(String id);
}
