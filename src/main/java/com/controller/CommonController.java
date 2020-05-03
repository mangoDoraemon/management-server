package com.controller;

import com.config.Global;
import com.constant.CommonConstant;
import com.dao.ClassInfoMapper;
import com.dao.CollegeMapper;
import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.entity.*;
import com.util.AjaxResult;
import com.util.file.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 13:15
 */
@RestController
public class CommonController {

    @Resource
    private CollegeMapper collegeMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    private static Logger logger = LoggerFactory.getLogger(CommonController.class);


    @RequestMapping("/message")
    public String getMessage() {
        logger.info("开始测试");
        return CommonConstant.MESSAGE;
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download")
    public void resourceDownload(@RequestParam("resource") String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath +"/"+"download/"+resource;
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("UTF-8");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }

    /**
     * 获取学院字典信息
     * @return
     */
    @GetMapping("/common/collegeDict")
    public AjaxResult getCollegeDict(){
       List<College> collegeList = collegeMapper.getCollegeDict();
       return AjaxResult.success(collegeList);
    }

    /**
     * 获取班级字典信息
     * @return
     */
    @GetMapping("/common/classInfoDict/{id}")
    public AjaxResult getClassInfoDict(@PathVariable String id){
       List<ClassInfo> classInfoList = classInfoMapper.getClassInfoDict(id);
       return AjaxResult.success(classInfoList);
    }

    /**
     * 获取教师字典信息
     * @return
     */
    @GetMapping("/common/teacherInfoDict")
    public AjaxResult getTeacherInfoDict(){
        List<Teacher> teacherList = teacherMapper.getTeacherInfoDict();
        return AjaxResult.success(teacherList);
    }

    /**
     * 获取没有选择可以的学生信息
     * @return
     */
    @GetMapping("/common/studentInfoDict")
    public AjaxResult getStudentInfoDict(){

        List<Student> studentList = studentMapper.selectStudentInfoDict();
        return AjaxResult.success(studentList);
    }

    @GetMapping("/common/getChartInfo")
    public charVo getChartInfo(){
        List<College> collegeList=collegeMapper.getChartInfo();
        List<String> expectedData = new ArrayList<>();
        List<Integer> actualData = new ArrayList<>();
        if(!CollectionUtils.isEmpty(collegeList)){
            for ( College college:collegeList
                  ) {
                 expectedData.add(college.getCollegeName());
                 actualData.add(college.getStudentTotal());
            }

        }
        charVo college=new charVo();
        college.setExpectedData(expectedData);
        college.setActualData(actualData);
        return college;
    }

}
