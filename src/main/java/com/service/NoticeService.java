package com.service;

import com.entity.Notice;
import com.github.pagehelper.PageInfo;
import com.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:14
 */
public interface NoticeService {
    PageInfo selectNoticeInfoData(Integer page, Integer limit, String fuzzy, HttpServletRequest request);

    AjaxResult insertNoticeInfo(Notice notice, HttpServletRequest request);

    AjaxResult fetchNoticeById(String id);

    AjaxResult deleteNotice(String id);
}
