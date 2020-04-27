package com.controller;

import com.github.pagehelper.PageInfo;
import com.service.TimeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/26 11:44
 */
@RestController
@RequestMapping("/timeLine")
public class TimeLineController {
    @Autowired
    private TimeLineService timeLineService;

    @GetMapping("/fetchTimeLineData")
    public PageInfo fetchTimeLineData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "4") Integer limit
                                         , HttpServletRequest httpRequest
                                         ){
        return timeLineService.fetchTimeLineData(page,limit,httpRequest);
    }
}
