package com.service.impl;

import com.constant.CommonConstant;
import com.dao.ClassInfoMapper;
import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.dao.UserInfoMapper;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ClassInfoService;
import com.util.AjaxResult;
import com.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/21 17:41
 */
@Service
public class ClassInfoServiceImpl implements ClassInfoService {

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo fetchData(Integer page, Integer limit, String fuzzy, String classCode, String className) {
        PageHelper.startPage(page,limit);
        ClassInfo classInfo = new ClassInfo();
        if(!StringUtils.isEmpty(fuzzy)){
             classInfo.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(classCode)){
            classInfo.setClassCode(classCode);
        }
        if(!StringUtils.isEmpty(className)){
            classInfo.setClassName(className);
        }
        List<ClassInfo> classInfoList = classInfoMapper.selectClassInfoAll(classInfo);
        return new PageInfo<>(classInfoList);
    }

    @Override
    public AjaxResult addData(ClassInfo classInfo, HttpServletRequest request) {
        if(classInfo != null){
            ClassInfoExample classInfoExample = new ClassInfoExample();
            classInfoExample.createCriteria().andClassCodeEqualTo(classInfo.getClassCode());
            List<ClassInfo> classInfoList = classInfoMapper.selectByExample(classInfoExample);
            if(!CollectionUtils.isEmpty(classInfoList)){
                return AjaxResult.error("该班级编号已经存在，请核对后再试");
            }
            classInfo.setId(UUID.randomUUID().toString());
            classInfo.setManageTime(new Date());
            HttpSession session=  request.getSession();
            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andIdEqualTo((String) session.getAttribute(CommonConstant.SESSION_USER_ID));
            List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);
            if(!CollectionUtils.isEmpty(userInfoList)){
                classInfo.setManageUser(userInfoList.get(0).getId());
            }

            classInfoMapper.insert(classInfo);
            return AjaxResult.success("维护班级信息成功");
        }else {
            return AjaxResult.error("维护班级信息失败");

        }
    }

    @Override
    public AjaxResult deleteData(String id) {
        if(!StringUtils.isEmpty(id)){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andStudentClassEqualTo(id);
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            if(!CollectionUtils.isEmpty(studentList)){
            return AjaxResult.error("改信息已经被使用，不可删除");
            }else {
                ClassInfoExample classInfoExample = new ClassInfoExample();
                classInfoExample.createCriteria().andClassCodeEqualTo(id);
                classInfoMapper.deleteByExample(classInfoExample);
                return AjaxResult.success("S删除成功");
            }
        }else {
            return AjaxResult.error("删除失败！");
        }
    }

    @Override
    public AjaxResult updateData(ClassInfo classInfo,HttpServletRequest request) {
        if(classInfo !=null){
            ClassInfoExample classInfoExample=new ClassInfoExample();
            classInfoExample.createCriteria().andIdNotEqualTo(classInfo.getId()).andClassCodeEqualTo(classInfo.getClassCode());
            List<ClassInfo> classInfoList=classInfoMapper.selectByExample(classInfoExample);
            if(!CollectionUtils.isEmpty(classInfoList)){
                return AjaxResult.error("改班级编号已经存在，请核对");
            }
            ClassInfoExample classInfoExample1 = new ClassInfoExample();
            classInfoExample1.createCriteria().andIdEqualTo(classInfo.getId());
            HttpSession session=  request.getSession();
            classInfo.setManageUser((String) session.getAttribute(CommonConstant.SESSION_USER_ID));
            classInfo.setManageTime(new Date());
            classInfoMapper.updateByExample(classInfo,classInfoExample1);
            return AjaxResult.success("修改成功");
        }else {
            return AjaxResult.error("修改失败");
        }
    }


    @Override
    public AjaxResult fetchTree(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
        ClassInfoExample classInfoExample = new ClassInfoExample();
        classInfoExample.createCriteria().andAuthIdEqualTo(authId);
        if(!StringUtils.isEmpty(authId)){
            List<ClassInfo> classInfoList = classInfoMapper.selectByExample(classInfoExample);
            return AjaxResult.success(classInfoList);
        }
        return AjaxResult.error("服务错误",new ArrayList<>());

    }

    @Override
    public PageInfo fetchMineClass(Integer page, Integer limit, String fuzzy, String classCode) {
        PageHelper.startPage(page,limit);
        Student student = new Student();
        if(!StringUtils.isEmpty(fuzzy)){
            student.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(classCode)){
            student.setStudentClass(classCode);
        }
        List<Student> studentList = studentMapper.selectMineClassInfo(student);
        return new PageInfo<>(studentList);
    }
}
