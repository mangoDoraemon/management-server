package com.controller;

import com.dao.TeacherMapper;
import com.entity.College;
import com.entity.Teacher;
import com.github.pagehelper.PageInfo;
import com.service.TeacherService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/10 17:59
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/fetchData")
    public PageInfo fetchData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                              @RequestParam(required = false) String teacherNumber, @RequestParam(required = false) String teacherName){
        return teacherService.fetchData(page,limit,fuzzy,teacherNumber,teacherName);
    }


    @PostMapping("/addData")
    public AjaxResult addData(@RequestBody Teacher teacher) throws Exception {
        return teacherService.addData(teacher);
    }

    @PutMapping("/updateData")
    public AjaxResult updateData(@RequestBody Teacher teacher){
        return teacherService.updateData(teacher);
    }

    @DeleteMapping("/deleteData/{id}")
    public AjaxResult deleteData(@PathVariable String id){
        return teacherService.deleteData(id);
    }

}
