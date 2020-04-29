package com.service.impl;

import com.constant.CommonConstant;
import com.dao.*;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserService;
import com.util.AjaxResult;
import com.util.DateUtils;
import com.util.Md5Encrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 16:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    Md5Encrypt md5Encrypt;

    @Resource
    UserInfoMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    TimeLineMapper timeLineMapper;

    @Override
    public AjaxResult login(String userName, String userPassword, HttpServletRequest request) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

        criteria.andUserNameEqualTo(userName);
        criteria.andUserPasswordEqualTo(userPassword);
        criteria.andStatusEqualTo("0000");
        List<UserInfo> userInfoList=userMapper.selectByExample(userInfoExample);

        if(userInfoList !=null && userInfoList.size()>0){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(CommonConstant.SESSION_TIMEOUT);
            session.setAttribute(CommonConstant.SESSION_USER_ID,userInfoList.get(0).getId());
            if(!StringUtils.isEmpty(userInfoList.get(0).getAuthId())){
                session.setAttribute(CommonConstant.SESSION_AUTH_ID,userInfoList.get(0).getAuthId());
            }

            TimeLine timeLine = new TimeLine();
            timeLine.setTitleId(UUID.randomUUID().toString());
            timeLine.setTitle(CommonConstant.TITLE);
            timeLine.setContent(userInfoList.get(0).getUserName()+CommonConstant.CONTENT+"--"+DateUtils.date2String(new Date()));
            timeLine.setTimeStamp(DateUtils.date2String(new Date()));
            timeLine.setManageTime(DateUtils.date2String(new Date()));
            timeLine.setStatus(CommonConstant.STATUS_INIT);
            timeLine.setUserId(userInfoList.get(0).getId());
            timeLineMapper.insert(timeLine);
            return AjaxResult.success("登陆成功",userInfoList.get(0));
        } else {
            return AjaxResult.warn("登陆失败，请检查您的用户名或密码是否正确");
        }

    }

    @Override
    public AjaxResult register(UserInfo user) {
        if(!StringUtils.isEmpty(user.getAuthId()) && !StringUtils.isEmpty(user.getRegisterType())){
            if(user.getRegisterType().equals(CommonConstant.REGISTER_TYPE_TEACHER)){
                TeacherExample teacherExample=new TeacherExample();
                TeacherExample.Criteria criteria = teacherExample.createCriteria();

                criteria.andTeacherNumberEqualTo(user.getAuthId());
                List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
                Teacher teacher=teacherList.get(0);
                if(!CollectionUtils.isEmpty(teacherList)){
                    if(teacherList.get(0).getStatus().equals(CommonConstant.STATUS_REGISTER)){
                        return AjaxResult.warn("该账户已被注册，请联系管理员");
                    }else {
                         teacher.setStatus("1111");
                         teacherMapper.updateByExampleSelective(teacher,teacherExample);
                    }
                }else {
                    return AjaxResult.warn("您输入的工号不匹配，请确认");
                }
            }
            if(user.getRegisterType().equals(CommonConstant.REGISTER_TYPE_USER)){
                StudentExample studentExample = new StudentExample();
                StudentExample.Criteria criteria = studentExample.createCriteria();

                criteria.andStudentNumberEqualTo(user.getAuthId());
                List<Student> studentList =studentMapper.selectByExample(studentExample);
                Student student=studentList.get(0);
                if(!CollectionUtils.isEmpty(studentList)){
                    if(studentList.get(0).getStatus().equals(CommonConstant.STATUS_REGISTER)){
                        return AjaxResult.warn("该账户已被注册，请联系管理员");
                    }else {
                         student.setStatus("1111");
                         studentMapper.updateByExampleSelective(student,studentExample);
                    }
                }else {
                    return AjaxResult.warn("您输入的学号不匹配，请确认");
                }
            }
        }
        String token = md5Encrypt.computeHexString(user.getUserName() + user.getUserPassword());
        user.setId(UUID.randomUUID().toString());
        user.setToken(token);
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        user.setStatus("0000");
        userMapper.insertSelective(user);

        Role role = new Role();
        if(!StringUtils.isEmpty(user.getRegisterType())){
          if(CommonConstant.REGISTER_TYPE_TEACHER.equals(user.getRegisterType())){
              role.setRoles("teacher");
          }else {
              role.setRoles("user");
          }
        }
        role.setId(UUID.randomUUID().toString());
        role.setUserId(user.getId());
        roleMapper.insertSelective(role);
        return AjaxResult.success("注册成功");
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(CommonConstant.SESSION_USER_ID);
        session.removeAttribute(CommonConstant.SESSION_AUTH_ID);
    }

    @Override
    public UserInfo getUserInfoByToken(String token) {
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();

        criteria.andTokenEqualTo(token);
        criteria.andStatusEqualTo("0000");
        List<UserInfo> userList = userMapper.selectByExample(userInfoExample);

        if(!CollectionUtils.isEmpty(userList)){
            UserInfo userInfo=userList.get(0);
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andUserIdEqualTo(userInfo.getId());
            List<Role> roleList = roleMapper.selectByExample(roleExample);
            if(!CollectionUtils.isEmpty(roleList)){
                    String roles = roleList.get(0).getRoles();
                    if(StringUtils.isNotBlank(roles)){
                        userInfo.setRoles(Arrays.asList(roles.split(",")) );
                    }
                    if(roles.contains(CommonConstant.REGISTER_TYPE_USER)){
                     StudentExample studentExample = new StudentExample();
                     studentExample.createCriteria().andStudentNumberEqualTo(userInfo.getAuthId());
                     List<Student> studentList = studentMapper.selectByExample(studentExample);
                     if(!CollectionUtils.isEmpty(studentList)){
                         Student student=studentList.get(0);
                         userInfo.setRealName(student.getStudentName());
                         userInfo.setUserPhone(student.getStudentPhone());
                         userInfo.setUserEmail(student.getStudentEmail());
                     }
                    }
                    if(roles.contains(CommonConstant.REGISTER_TYPE_TEACHER)){
                        TeacherExample teacherExample = new TeacherExample();
                        teacherExample.createCriteria().andTeacherNumberEqualTo(userInfo.getAuthId());
                        List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
                        if(!CollectionUtils.isEmpty(teacherList)){
                            Teacher teacher = teacherList.get(0);
                            userInfo.setRealName(teacher.getTeacherName());
                            userInfo.setUserPhone(teacher.getTeacherPhone());
                            userInfo.setUserEmail(teacher.getTeacherEmail());
                        }
                    }
            }
            return userInfo;
        }
        return new UserInfo();
    }

    @Override
    public AjaxResult modify(UserInfo userInfo, HttpServletRequest request) {
        if(userInfo != null){
            UserInfoExample userInfoExample = new UserInfoExample();
            userInfoExample.createCriteria().andIdEqualTo(userInfo.getId());
            if(!CollectionUtils.isEmpty(userInfo.getRoles())){
                String roles = String.join(",",userInfo.getRoles());
                if(roles.contains(CommonConstant.REGISTER_TYPE_USER)){
                    StudentExample studentExample = new StudentExample();
                    studentExample.createCriteria().andStudentNumberEqualTo(userInfo.getAuthId());
                    List<Student> studentList = studentMapper.selectByExample(studentExample);
                   if(!CollectionUtils.isEmpty(studentList)){
                       Student student=studentList.get(0);
                       student.setStudentEmail(userInfo.getUserEmail());
                       student.setStudentName(userInfo.getRealName());
                       student.setStudentPhone(userInfo.getUserPhone());
                       student.setManageTime(new Date());
                       studentMapper.updateByExampleSelective(student,studentExample);
                   }

                }
                if(roles.contains(CommonConstant.REGISTER_TYPE_TEACHER)){
                     TeacherExample teacherExample = new TeacherExample();
                     teacherExample.createCriteria().andTeacherNumberEqualTo(userInfo.getAuthId());
                     List<Teacher> teacherList = teacherMapper.selectByExample(teacherExample);
                     if(!CollectionUtils.isEmpty(teacherList)){
                         Teacher teacher = teacherList.get(0);
                         teacher.setTeacherEmail(userInfo.getUserEmail());
                         teacher.setTeacherName(userInfo.getRealName());
                         teacher.setTeacherPhone(userInfo.getUserPhone());
                         teacher.setManageTime(new Date());
                         teacherMapper.updateByExampleSelective(teacher,teacherExample);
                     }
                }
            }
            userInfo.setIntroduction("请编辑您的个人信息");
            userMapper.updateByExampleSelective(userInfo,userInfoExample);
            return AjaxResult.success("修改信息成功");
        }else {
            return AjaxResult.warn("修改信息失败，请稍后再试！");
        }

    }

    @Override
    public PageInfo fetchUserInfoData(Integer page, Integer limit, String fuzzy, String userName, String authId) {
        PageHelper.startPage(page,limit);
        UserInfo userInfo=new UserInfo();
        if(!StringUtils.isEmpty(fuzzy)){
            userInfo.setFuzzy(fuzzy);
        }
        if(!StringUtils.isEmpty(userName)){
            userInfo.setUserName(userName);
        }
        if(!StringUtils.isEmpty(authId)){
            userInfo.setAuthId(authId);
        }
        List<UserInfo> userInfoList = userMapper.selectUserInfoAll(userInfo);
        if(!CollectionUtils.isEmpty(userInfoList)){
            for (UserInfo u:userInfoList
                 ) {
                if(!StringUtils.isEmpty(u.getId())){
                    String roles = userMapper.getRoleById(u.getId());
                    if(!StringUtils.isEmpty(roles)){
                        u.setRoles(Arrays.asList(roles.split(",")));
                    }
                    if(!StringUtils.isEmpty(u.getStatus())){
                        if(CommonConstant.STATUS_INIT.equals(u.getStatus())){
                            u.setStatusName("正常");
                        }
                    }

                }
            }

        }
        return new PageInfo<>(userInfoList);
    }

    @Override
    public AjaxResult deleteUser(String id) {
        UserInfo userInfo = userMapper.getUserInfoById(id);
        Role role=roleMapper.getRoleInfoByUserId(id);
        if(userInfo !=null && !StringUtils.isEmpty(userInfo.getAuthId())
                && role !=null && !StringUtils.isEmpty(role.getRoles())){
            RoleExample roleExample = new RoleExample();
            roleExample.createCriteria().andIdEqualTo(role.getId());
               if(role.getRoles().contains(CommonConstant.REGISTER_TYPE_USER)){
                   StudentExample studentExample = new StudentExample();
                   studentExample.createCriteria().andStudentNumberEqualTo(userInfo.getAuthId());
                   List<Student> student=studentMapper.selectByExample(studentExample);
                   Student student1=student.get(0);
                   student1.setStatus("0000");
                   studentMapper.updateByExampleSelective(student1,studentExample);
                   roleMapper.deleteByExample(roleExample);
               }if(role.getRoles().contains(CommonConstant.REGISTER_TYPE_TEACHER)){
                   TeacherExample teacherExample = new TeacherExample();
                   teacherExample.createCriteria().andTeacherNumberEqualTo(userInfo.getAuthId());
                   List<Teacher> teacherList=teacherMapper.selectByExample(teacherExample);
                   Teacher teacher=teacherList.get(0);
                   teacher.setStatus("0000");
                   teacherMapper.updateByExampleSelective(teacher,teacherExample);
                   roleMapper.deleteByExample(roleExample);
            }
        }
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andIdEqualTo(id);
        userMapper.deleteByExample(userInfoExample);
        return AjaxResult.success("删除成功");
    }

    /**
     * 修改个人信息
     * @param userInfo
     * @param request
     * @return
     */
    @Override
    public AjaxResult modifyOwn(UserInfo userInfo, HttpServletRequest request) {
        if(userInfo!=null){
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute(CommonConstant.SESSION_USER_ID);
            UserInfoExample userInfoExample=new UserInfoExample();
            userInfoExample.createCriteria().andIdEqualTo(userId);
            List<UserInfo> userInfoList = userMapper.selectByExample(userInfoExample);
            if(!CollectionUtils.isEmpty(userInfoList)){
                UserInfo userInfo1=userInfoList.get(0);
                userInfo.setId(userInfo1.getId());
                if(StringUtils.isEmpty(userInfo.getUserPassword())){
                    userInfo.setUserPassword(userInfo1.getUserPassword());
                }
                Role role = roleMapper.getRoleInfoByUserId(userId);

                if(role.getRoles().contains(CommonConstant.REGISTER_TYPE_TEACHER)){
                    TeacherExample teacherExample = new TeacherExample();
                    teacherExample.createCriteria().andTeacherNumberEqualTo(userInfo1.getAuthId());
                    Teacher teacher = new Teacher();
                    teacher.setTeacherName(userInfo.getRealName());
                    teacher.setTeacherEmail(userInfo.getUserEmail());
                    teacher.setTeacherPhone(userInfo.getUserPhone());
                    teacherMapper.updateByExampleSelective(teacher,teacherExample);
                }
                if(role.getRoles().contains(CommonConstant.REGISTER_TYPE_USER)){
                    StudentExample studentExample = new StudentExample();
                    studentExample.createCriteria().andStudentNumberEqualTo(userInfo1.getAuthId());
                    Student student = new Student();
                    student.setStudentName(userInfo.getRealName());
                    student.setStudentEmail(userInfo.getUserEmail());
                    student.setStudentPhone(userInfo.getUserPhone());
                    studentMapper.updateByExampleSelective(student,studentExample);
                }
                userMapper.updateByExampleSelective(userInfo,userInfoExample);
                return AjaxResult.success("更新信息成功");
            }
        }
            return AjaxResult.error("更新信息失败");


    }
}
