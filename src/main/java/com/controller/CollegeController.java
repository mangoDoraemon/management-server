package com.controller;

import com.entity.College;
import com.entity.Student;
import com.github.pagehelper.PageInfo;
import com.service.CollegeService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:18
 */

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/fetchData")
    public PageInfo fetchData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                              @RequestParam(required = false) String collegeCode, @RequestParam(required = false) String collegeName){
        return collegeService.fetchData(page,limit,fuzzy,collegeCode,collegeName);
    }


    @PostMapping("/addData")
    public AjaxResult addData(@RequestBody College college) throws Exception {
        return collegeService.addData(college);
    }

    @PutMapping("/updateData")
    public AjaxResult updateData(@RequestBody College college){
        return collegeService.updateData(college);
    }

    @DeleteMapping("/deleteData/{id}")
    public AjaxResult deleteData(@PathVariable String id){
        return collegeService.deleteData(id);
    }

}
