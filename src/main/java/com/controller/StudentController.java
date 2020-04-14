package com.controller;

import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/10 17:58
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/fetchStudentInfoData")
    public PageInfo fetchStudentInfoData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize, @RequestParam(required = false) String fuzzy,
                                         @RequestParam(required = false) String studentNumber, @RequestParam(required = false) String studentName
    ){
        return studentService.selectStudentInfoData(page,pageSize,fuzzy,studentNumber,studentName);
    }


}
