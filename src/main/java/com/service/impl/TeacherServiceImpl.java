package com.service.impl;

import com.constant.CommonConstant;
import com.dao.ClassInfoMapper;
import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.TeacherService;
import com.util.AjaxResult;
import com.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:10
 */

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private ClassInfoMapper classInfoMapper;

    @Override
    public PageInfo fetchData(Integer page, Integer limit, String fuzzy, String teacherNumber, String teacherName) {
        PageHelper.startPage(page,limit);
        Teacher teacher = new Teacher();
        if(!StringUtils.isEmpty(fuzzy)){
               teacher.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(teacherNumber)){
            teacher.setTeacherNumber(teacherNumber);
        }
        if(!StringUtils.isEmpty(teacherName)){
            teacher.setTeacherName(teacherName);
        }
        List<Teacher> teacherList = teacherMapper.selectTeacherInfoAll(teacher);
        if(!CollectionUtils.isEmpty(teacherList)){

            for (Teacher t:teacherList

                 ) {
                List<String> className = new ArrayList<>();
                List<String> classCode = new ArrayList<>();
                if(!StringUtils.isEmpty(t.getTeacherNumber())){
                    List<ClassInfo> classInfoList=classInfoMapper.selectClassNameByTeacherNumber(t.getTeacherNumber());
                    if(!CollectionUtils.isEmpty(classInfoList)){
                        for (ClassInfo c:classInfoList
                             ) {
                            className.add(c.getClassName());
                            classCode.add(c.getClassCode());
                        }
                    }
                    t.setClassName(String.join(",",className));
                    t.setClassCode(String.join(",",classCode));
                }
            }
        }
        return new PageInfo<>(teacherList);
    }

    @Override
    public AjaxResult addData(Teacher teacher) {
       if(teacher != null){
           TeacherExample teacherExample = new TeacherExample();
           teacherExample.createCriteria().andTeacherNumberEqualTo(teacher.getTeacherNumber());
           List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
           if(!CollectionUtils.isEmpty(teacherList)){
               return AjaxResult.error("该教师编号已经存在，请核对后再试");
           }
           teacher.setId(UUID.randomUUID().toString());
           teacher.setManageTime(new Date());
           teacher.setStatus(CommonConstant.STATUS_INIT);
           teacherMapper.insert(teacher);
           return AjaxResult.success("添加教师信息成功");
       }else {
           return AjaxResult.error("服务器开小差了，请稍后再试");
       }

    }

    @Override
    public AjaxResult updateData(Teacher teacher) {
        if(teacher !=null){
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andIdNotEqualTo(teacher.getId()).andTeacherNumberEqualTo(teacher.getTeacherNumber());
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
            if(!CollectionUtils.isEmpty(teacherList)){
                return AjaxResult.error("教师编号已存在，请核对");
            }
            teacher.setManageTime(new Date());
            TeacherExample teacherExample1 = new TeacherExample();
            teacherExample1.createCriteria().andIdEqualTo(teacher.getId());
            teacherMapper.updateByExample(teacher,teacherExample1);
            return AjaxResult.success("修改成功");
        }else {
            return AjaxResult.error("修改失败");
        }
    }

    @Override
    public AjaxResult deleteData(String id) {
        if(!StringUtils.isEmpty(id)){
            TeacherExample teacherExample1 = new TeacherExample();
            teacherExample1.createCriteria().andIdEqualTo(id);
            List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample1);
            if(!CollectionUtils.isEmpty(teacherList)){
                Teacher teacher = teacherList.get(0);
                if(teacher.getStatus().equals(CommonConstant.STATUS_REGISTER)){
                    return AjaxResult.error("该教师信息已经被注册，不可删除");
                }
                if(teacher.getStatus().equals(CommonConstant.STATUS_INIT)){
                    TeacherExample teacherExample = new TeacherExample();
                    teacherExample.createCriteria().andTeacherNumberEqualTo(id);
                    teacherMapper.deleteByExample(teacherExample);
                    return AjaxResult.success("删除成功");
                }

            }
        }
            return AjaxResult.error("删除失败！");

    }

    @Override
    public PageInfo fetchMineStudent(Integer page, Integer limit, String fuzzy, String studentNumber, String studentName) {
        return null;
    }
}
