package com.service.impl;

import com.constant.CommonConstant;
import com.dao.TimeLineMapper;
import com.entity.TimeLine;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.TimeLineService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/26 11:45
 */
@Service
public class TimeLineServiceImpl implements TimeLineService {

    @Resource
    private TimeLineMapper timeLineMapper;

    @Override
    public PageInfo fetchTimeLineData(Integer page, Integer limit, HttpServletRequest httpRequest) {
        PageHelper.startPage(page,limit);
        HttpSession session = httpRequest.getSession();
        String userId= (String) session.getAttribute(CommonConstant.SESSION_USER_ID);
        List<TimeLine> timeLineList = timeLineMapper.selectTimeLineData(userId);
        return new PageInfo<>(timeLineList);
    }
}
