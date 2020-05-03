package com.service.impl;

import com.constant.CommonConstant;
import com.dao.CollegeMapper;
import com.dao.StudentMapper;
import com.dao.SubjectMapper;
import com.entity.Student;
import com.entity.StudentExample;
import com.entity.Subject;
import com.entity.SubjectExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.SubjectService;
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
 * @Date: 2020/4/13 17:13
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private StudentMapper studentMapper;


    @Override
    public AjaxResult addAndUpdateData(Subject subject, HttpServletRequest request) {

        if(subject !=null){
            HttpSession session = request.getSession();
            String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
            if(StringUtils.isEmpty(subject.getId())){
                subject.setId(UUID.randomUUID().toString());
                subject.setReleaseTime(new Date());
                subject.setReleasePeople(authId);
                subjectMapper.insert(subject);
                if(subject.getStatus().equals(CommonConstant.SUCCESS)){
                    return AjaxResult.success("发布课题成功");
                }
            }else {
                SubjectExample subjectExample = new SubjectExample();
                subjectExample.createCriteria().andIdEqualTo(subject.getId());
                subject.setReleaseTime(new Date());
                subject.setReleasePeople(authId);
                subjectMapper.updateByExampleSelective(subject,subjectExample);
                if(subject.getStatus().equals(CommonConstant.SUCCESS)){
                    return AjaxResult.success("修改课题信息成功");
                }else {
                    return AjaxResult.success("暂停课题成功");
                }

            }
        }
        return AjaxResult.success("操作失败!!!");
    }

    /**
     * 查看自己的课题
     * @param page
     * @param limit
     * @param fuzzy
     * @param request
     * @return
     */
    @Override
    public PageInfo fetchOwnData(Integer page, Integer limit, String fuzzy, HttpServletRequest request) {
        PageHelper.startPage(page,limit);
        Subject subject = new Subject();
        if(!org.apache.commons.lang3.StringUtils.isEmpty(fuzzy)){
            subject.setFuzzy(fuzzy);
        }
        HttpSession session = request.getSession();
        String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
        if(!StringUtils.isEmpty(authId)){
            subject.setAuthId(authId);
        }else {
            return new PageInfo<>();
        }
        List<Subject> subjectList = subjectMapper.selectOwnData(subject);
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
            }
        }
        return new PageInfo<>(subjectList);
    }

    @Override
    public AjaxResult fetchDataById(String id) {
        if(!StringUtils.isEmpty(id)){
            return AjaxResult.success(subjectMapper.selectSubjectById(id));
        }else {
            return AjaxResult.error("服务器错误");
        }
    }

    @Override
    public AjaxResult fetchTree(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String authId = (String) session.getAttribute(CommonConstant.SESSION_AUTH_ID);
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andReleasePeopleEqualTo(authId);
        if(!StringUtils.isEmpty(authId)){
            List<Subject> subjectList = subjectMapper.selectByExample(subjectExample);
            return AjaxResult.success(subjectList);
        }
        return AjaxResult.error("服务错误",new ArrayList<>());

    }

    @Override
    public AjaxResult fetchMineStudent(String id, HttpServletRequest request) {
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andSubjectIdEqualTo(id);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if(!CollectionUtils.isEmpty(studentList)){
            for (Student student: studentList
                 ) {
                if(!StringUtils.isEmpty(student.getSubjectId())){
                    String subjectName = studentMapper.selectSubjectById(student.getSubjectId());
                    student.setSubjectName(subjectName);
                }

            }
            return AjaxResult.success(studentList);
        }
        return AjaxResult.success(new ArrayList<>());
    }

    @Override
    public AjaxResult deleteMineStudent(String id, HttpServletRequest request) {
        if(!StringUtils.isEmpty(id)){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdEqualTo(id);
            List<Student> studentList = studentMapper.selectByExample(studentExample);
            if(!CollectionUtils.isEmpty(studentList)){
                Student student = studentList.get(0);
                student.setSubjectId(" ");
                studentMapper.updateByExampleSelective(student,studentExample);
            }

        }
        return AjaxResult.success("移除成功");
    }

    @Override
    public AjaxResult updateMineStudent(Student student, HttpServletRequest request) {
        if(student != null){
            if(!StringUtils.isEmpty(student.getStudentNumber())){
                String[] arr = student.getStudentNumber().split(",");
                for(int i=0;i<arr.length;i++){
                    StudentExample studentExample = new StudentExample();
                    studentExample.createCriteria().andStudentNumberEqualTo(arr[i]);
                    List<Student> studentList = studentMapper.selectByExample(studentExample);
                    if(!CollectionUtils.isEmpty(studentList)){
                        Student student1 = studentList.get(0);
                        student1.setSubjectId(student.getSubjectId());
                        studentMapper.updateByExampleSelective(student1,studentExample);

                    }
                }
                return AjaxResult.success("操作成功");
            }

        }
        return AjaxResult.error("操作失败，请稍后再试");
    }
}
