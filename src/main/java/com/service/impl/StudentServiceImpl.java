package com.service.impl;

import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:06
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public PageInfo selectStudentInfoData(Integer page, Integer pageSize, String fuzzy, String studentNumber, String studentName) {
        return null;
    }
}
