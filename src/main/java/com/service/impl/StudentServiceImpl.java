package com.service.impl;

import com.constant.CommonConstant;
import com.dao.*;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import com.util.AjaxResult;
import com.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:06
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentMapper studentMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    ClassInfoMapper classInfoMapper;

    @Resource
    CollegeMapper collegeMapper;

    @Resource
    SubjectMapper subjectMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public PageInfo selectStudentInfoData(Integer page, Integer limit, String fuzzy, String studentNumber, String studentName) {
        PageHelper.startPage(page,limit);
        Student student = new Student();
        if(!StringUtils.isEmpty(fuzzy)){
          student.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(studentName)){
            student.setStudentName(studentName);
        }
        if(!StringUtils.isEmpty(studentNumber)){
            student.setStudentNumber(studentNumber);
        }
        List<Student> studentList = studentMapper.selectStudentInfoAll(student);
        if(!CollectionUtils.isEmpty(studentList)){
            for (Student s:studentList
                 ) {
                if(!StringUtils.isEmpty(s.getStudentClass())){
                    ClassInfoExample classInfoExample = new ClassInfoExample();
                    classInfoExample.createCriteria().andClassCodeEqualTo(s.getStudentClass());
                    List<ClassInfo> classInfoList = classInfoMapper.selectByExample(classInfoExample);
                    if(!CollectionUtils.isEmpty(classInfoList)){
                        s.setClassName(classInfoList.get(0).getClassName());
                    }
                }

                if(!StringUtils.isEmpty(s.getStudentCollege())){
                    CollegeExample collegeExample = new CollegeExample();
                    collegeExample.createCriteria().andCollegeCodeEqualTo(s.getStudentCollege());
                    List<College> collegeList = collegeMapper.selectByExample(collegeExample);
                    if(!CollectionUtils.isEmpty(collegeList)){
                        s.setCollegeName(collegeList.get(0).getCollegeName());
                    }
                }
            }
        }
        return new PageInfo<>(studentList);
    }

    @Override
    public AjaxResult addStudentInfo(Student student) {
        if(student != null){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdEqualTo(student.getStudentNumber());
            List<Student> studentList=studentMapper.selectByExample(studentExample);
            if(!CollectionUtils.isEmpty(studentList)){
               return AjaxResult.error("该学号已经存在，请核对学号是否输入正确");
            }
            student.setId(UUID.randomUUID().toString());
            student.setManageTime(new Date());
            student.setStatus(CommonConstant.STATUS_INIT);
            studentMapper.insert(student);
            return AjaxResult.success("添加学生信息成功");
        }else {
            return AjaxResult.error("服务器开小差了，请稍后再试");
        }

    }

    @Override
    public AjaxResult deleteStudent(String id) {
        if(!StringUtils.isEmpty(id)){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdEqualTo(id);
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            if(!CollectionUtils.isEmpty(studentList)){
                Student student=studentList.get(0);
                if(student.getStatus().equals(CommonConstant.STATUS_REGISTER)){
                    return AjaxResult.error("该学生信息已经被注册，不可删除");
                }
                if(student.getStatus().equals(CommonConstant.STATUS_INIT)){
                    StudentExample studentExample1=new StudentExample();
                    studentExample1.createCriteria().andIdEqualTo(id);
                    studentMapper.deleteByExample(studentExample1);
                    return AjaxResult.success("删除成功");
                }
            }
        }
            return AjaxResult.error("删除失败！");
    }

    @Override
    public AjaxResult updateStudent(Student student) {
           if(student != null){
               StudentExample studentExample = new StudentExample();
               studentExample.createCriteria().andIdEqualTo(student.getId());

               student.setManageTime(new Date());
               studentMapper.updateByExample(student,studentExample);
               return AjaxResult.success("修改成功");
           }else {
               return AjaxResult.error("修改失败");
           }

    }

    @Override
    public PageInfo fetchSubject(Integer page, Integer limit, String fuzzy, HttpServletRequest request) {
        PageHelper.startPage(page,limit);
        HttpSession session = request.getSession();
        String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentNumberEqualTo(authId);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        Student student = studentList.get(0);
        Subject subject = new Subject();
        if(!StringUtils.isEmpty(fuzzy)){
            subject.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(student.getStudentCollege())){
            subject.setCollegeId(student.getStudentCollege());
        }
        if(!StringUtils.isEmpty(student.getSubjectId())){
            subject.setId(student.getSubjectId());
        }
        List<Subject> subjectList = studentMapper.selectSubject(subject);
        if(!CollectionUtils.isEmpty(subjectList)){
            for (Subject s:subjectList
            ) {
                if(s.getStatus().equals(CommonConstant.SUCCESS)){
                    s.setStatusName("正常");
                }
                if(s.getStatus().equals(CommonConstant.STOP)){
                    s.setStatusName("停止");
                }
                if(!StringUtils.isEmpty(s.getCollegeId())){
                    String collegeName=collegeMapper.selectCollegeNameBycode(s.getCollegeId());
                    s.setCollegeName(collegeName);
                }
                if(!org.apache.commons.lang.StringUtils.isEmpty(s.getReleasePeople())){
                    TeacherExample teacherExample = new TeacherExample();
                    teacherExample.createCriteria().andTeacherNumberEqualTo(s.getReleasePeople());
                    List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
                    s.setReleasePeopleName(teacherList.get(0).getTeacherName());
                }
            }
        }
        return new PageInfo<>(subjectList);
    }

    @Override
    public AjaxResult chooseSubject(String id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentNumberEqualTo(authId);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        Student student = studentList.get(0);
        if(!StringUtils.isEmpty(id)){
            student.setSubjectId(id);
            studentMapper.updateByExampleSelective(student,studentExample);
            return AjaxResult.success("选择课题成功");
        }
        return AjaxResult.error("服务器错误");
    }
}
