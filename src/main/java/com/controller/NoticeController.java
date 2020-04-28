package com.controller;

import com.entity.Notice;
import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import com.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/10 17:59
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 列表查询
     * @param page
     * @param limit
     * @param fuzzy
     * @return
     */
    @GetMapping("/fetchNoticeInfoData")
    public PageInfo fetchNoticeInfoData(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false) String fuzzy,
                                        HttpServletRequest request){
        return noticeService.selectNoticeInfoData(page,limit,fuzzy,request);
    }

    /**
     * 根据ID获取公告信息
     * @param id
     * @return
     */
    @GetMapping("/fetchNoticeById/{id}")
    public AjaxResult fetchNoticeById(@PathVariable String id){
        return noticeService.fetchNoticeById(id);
    }

    @PostMapping("/insertNoticeInfo")
    public AjaxResult insertNoticeInfo(@RequestBody Notice notice, HttpServletRequest request){
        return noticeService.insertNoticeInfo(notice,request);
    }

    @DeleteMapping("/deleteNotice/{id}")
    public AjaxResult deleteNotice(@PathVariable String id){
        return noticeService.deleteNotice(id);
    }

}
