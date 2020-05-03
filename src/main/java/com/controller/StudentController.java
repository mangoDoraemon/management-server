package com.controller;

import com.entity.Student;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public PageInfo fetchStudentInfoData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                                         @RequestParam(required = false) String studentNumber, @RequestParam(required = false) String studentName
    ){
        return studentService.selectStudentInfoData(page,limit,fuzzy,studentNumber,studentName);
    }


    @PostMapping("/addStudentInfo")
    public AjaxResult addStudentInfo(@RequestBody Student student) throws Exception {
        return studentService.addStudentInfo(student);
    }


    @DeleteMapping("/deleteStudent/{id}")
    public AjaxResult deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/updateStudent")
    public AjaxResult updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/fetchSubject")
    public PageInfo fetchSubject(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                                 HttpServletRequest request

    ){
        return studentService.fetchSubject(page,limit,fuzzy,request);
    }

    @PutMapping("/chooseSubject/{id}")
    public AjaxResult chooseSubject(@PathVariable String id,HttpServletRequest request){
        return studentService.chooseSubject(id,request);
    }
}
