package com.service;

import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/26 11:44
 */
public interface TimeLineService {
    PageInfo fetchTimeLineData(Integer page, Integer limit, HttpServletRequest httpRequest);
}
