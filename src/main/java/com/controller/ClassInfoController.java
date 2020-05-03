package com.controller;

import com.entity.ClassInfo;
import com.entity.College;
import com.github.pagehelper.PageInfo;
import com.service.ClassInfoService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:17
 */
@RestController
@RequestMapping("/class")
public class ClassInfoController {

    @Autowired
    private ClassInfoService classInfoService;

    @GetMapping("/fetchData")
    public PageInfo fetchData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                              @RequestParam(required = false) String classCode, @RequestParam(required = false) String className){
        return classInfoService.fetchData(page,limit,fuzzy,classCode,className);
    }

    @PostMapping("/addData")
    public AjaxResult addData(@RequestBody ClassInfo classInfo, HttpServletRequest request) throws Exception {
        return classInfoService.addData(classInfo,request);
    }

    @PutMapping("/updateData")
    public AjaxResult updateData(@RequestBody ClassInfo classInfo,HttpServletRequest request){
        return classInfoService.updateData(classInfo,request);
    }

    @DeleteMapping("/deleteData/{id}")
    public AjaxResult deleteData(@PathVariable String id){
        return classInfoService.deleteData(id);
    }

    @GetMapping("/fetchTree")
    public AjaxResult fetchTree(HttpServletRequest request){
        return classInfoService.fetchTree(request);
    }

    @GetMapping("/fetchMineClass")
    public PageInfo fetchMineClass(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                              @RequestParam(required = false) String classCode){
        return classInfoService.fetchMineClass(page,limit,fuzzy,classCode);
    }
}
