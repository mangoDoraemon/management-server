package com.service;

import com.github.pagehelper.PageInfo;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:05
 */
public interface StudentService {
    PageInfo selectStudentInfoData(Integer page, Integer pageSize, String fuzzy, String studentNumber, String studentName);
}
