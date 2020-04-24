package com.controller;

import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/10 17:59
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/fetchNoticeInfoData")
    public PageInfo fetchNoticeInfoData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy){
        return noticeService.selectNoticeInfoData(page,limit,fuzzy);
    }

}
