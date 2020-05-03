package com.controller;

import com.entity.Student;
import com.entity.Subject;
import com.github.pagehelper.PageInfo;
import com.service.SubjectService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/10 18:00
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

//    @GetMapping("/fetchData")
//    public PageInfo fetchData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
//                              @RequestParam(required = false) String collegeCode, @RequestParam(required = false) String collegeName){
//        return subjectService.fetchData(page,limit,fuzzy,collegeCode,collegeName);
//    }

    @PostMapping("/addAndUpdateData")
    public AjaxResult addAndUpdateData(@RequestBody Subject subject, HttpServletRequest request) throws Exception {
        return subjectService.addAndUpdateData(subject,request);
    }

    /**
     * 自己课题查询
     * @param page
     * @param limit
     * @param fuzzy
     * @param request
     * @return
     */
    @GetMapping("/fetchOwnData")
    public PageInfo fetchOwnData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit,
                                 @RequestParam(required = false) String fuzzy,HttpServletRequest request){

        return subjectService.fetchOwnData(page,limit,fuzzy,request);
    }

    @GetMapping("/fetchDataById/{id}")
    public AjaxResult fetchDataById(@PathVariable String id){

        return subjectService.fetchDataById(id);
    }

    @GetMapping("/fetchTree")
    public AjaxResult fetchTree(HttpServletRequest request){
        return subjectService.fetchTree(request);
    }

    @GetMapping("/fetchMineStudent/{id}")
    public AjaxResult fetchMineStudent(@PathVariable String id,HttpServletRequest request){
        return subjectService.fetchMineStudent(id,request);
    }

    @DeleteMapping("/deleteMineStudent/{id}")
    public AjaxResult deleteMineStudent(@PathVariable String id,HttpServletRequest request){
       return subjectService.deleteMineStudent(id,request);
    }

    @PutMapping("/updateMineStudent")
    public AjaxResult updateMineStudent(@RequestBody Student student,HttpServletRequest request){
        return subjectService.updateMineStudent(student,request);
    }

}
