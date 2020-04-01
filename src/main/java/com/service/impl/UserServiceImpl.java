package com.service.impl;

import com.constant.CommonConstant;
import com.dao.RoleMapper;
import com.dao.StudentMapper;
import com.dao.TeacherMapper;
import com.dao.UserInfoMapper;
import com.entity.*;
import com.service.UserService;
import com.util.AjaxResult;
import com.util.Md5Encrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
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

    @Override
    public UserInfo login(String userName, String userPassword, HttpServletRequest request) {
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

            return userInfoList.get(0);
        } else {
            return new UserInfo();
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
                if(!CollectionUtils.isEmpty(teacherList)){
                    if(teacherList.get(0).getStatus().equals(CommonConstant.STATUS_REGISTER)){
                        return AjaxResult.warn("该账户已被注册，请联系管理员");
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
                if(!CollectionUtils.isEmpty(studentList)){
                    if(studentList.get(0).getStatus().equals(CommonConstant.STATUS_REGISTER)){
                        return AjaxResult.warn("该账户已被注册，请联系管理员");
                    }else {
                        return AjaxResult.warn("您输入的学号不匹配，请确认");
                    }
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
        return AjaxResult.success("修改成功");
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(CommonConstant.SESSION_USER_ID);
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
            }
            return userInfo;
        }
        return new UserInfo();
    }
}
