package com.service.impl;

import com.constant.CommonConstant;
import com.dao.NoticeMapper;
import com.dao.RoleMapper;
import com.dao.UserInfoMapper;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import com.util.AjaxResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:15
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private NoticeMapper noticeMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo selectNoticeInfoData(Integer page, Integer limit, String fuzzy, HttpServletRequest request) {
        PageHelper.startPage(page,limit);
        Notice notice = new Notice();
        if(!StringUtils.isEmpty(fuzzy)){
            notice.setFuzzy(fuzzy);
        }
        List<Integer> roles = new ArrayList<>();
        HttpSession httpSession = request.getSession();
        String userId= (String) httpSession.getAttribute(CommonConstant.SESSION_USER_ID);
        if(StringUtils.isEmpty(userId)){
            return new PageInfo<>();
        }
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andUserIdEqualTo(userId);
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        if(!CollectionUtils.isEmpty(roleList)){
            if(roleList.get(0).getRoles().contains(CommonConstant.REGISTER_TYPE_TEACHER)){
                //只查看教师自己的公告
                notice.setUserNumber((String) httpSession.getAttribute(CommonConstant.SESSION_AUTH_ID));
                roles.add(1);
            }else if(roleList.get(0).getRoles().contains(CommonConstant.ADMIN_ROLE)){
                //查看所有人的公告信息
                roles.add(2);
            }
        }
        notice.setRoles(roles);
        List<Notice> noticeList = noticeMapper.selectNoticeInfoData(notice);
        if(!CollectionUtils.isEmpty(noticeList)){
            for (Notice n:noticeList
                 ) {
                if(n.getStatus().equals(CommonConstant.NOTICE_DRAFT)){
                    n.setStatusName("草稿");
                }
                if(n.getStatus().equals(CommonConstant.NOTICE_PUBLISHED)){
                    n.setStatusName("已发布");
                }

            }
        }
        return new PageInfo<>(noticeList);
    }

    @Override
    public AjaxResult insertNoticeInfo(Notice notice, HttpServletRequest request) {

         if(notice != null){
            //新增操作
            if(StringUtils.isEmpty(notice.getId())){
                notice.setId(UUID.randomUUID().toString());
                notice.setManageDate(new Date());
                notice.setAuthId((String) request.getSession().getAttribute(CommonConstant.SESSION_AUTH_ID));
                noticeMapper.insertSelective(notice);
                if(notice.getStatus().equals(CommonConstant.NOTICE_DRAFT)){
                    return AjaxResult.success("存储草稿信息成功");
                }else {
                    return AjaxResult.success("发布信息成功");
                }


            }else {
                notice.setManageDate(new Date());
                notice.setAuthId((String) request.getSession().getAttribute(CommonConstant.SESSION_AUTH_ID));
                NoticeExample noticeExample = new NoticeExample();
                noticeExample.createCriteria().andIdEqualTo(notice.getId());
                notice.setAuthId((String) request.getSession().getAttribute(CommonConstant.SESSION_AUTH_ID));
                noticeMapper.updateByExampleSelective(notice,noticeExample);
                return AjaxResult.success("修改信息成功");
            }
        }
        return AjaxResult.error("修改失败");
    }

    @Override
    public AjaxResult fetchNoticeById(String id) {
        if(!StringUtils.isEmpty(id)){
            Notice notice=noticeMapper.selectNoticeById(id);
             return AjaxResult.success(notice);

        }
       return AjaxResult.warn("服务器出现错误了，请稍候再试");
    }

    @Override
    public AjaxResult deleteNotice(String id) {
        if(!StringUtils.isEmpty(id)){
            NoticeExample noticeExample = new NoticeExample();
            noticeExample.createCriteria().andIdEqualTo(id);
            noticeMapper.deleteByExample(noticeExample);
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.warn("服务器出现错误了，请稍候再试");
    }
}
