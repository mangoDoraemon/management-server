package com.service;

import com.github.pagehelper.PageInfo;

/**
 * @Author: wangjingyuan
 * @Date: 2020/4/13 17:14
 */
public interface NoticeService {
    PageInfo selectNoticeInfoData(Integer page, Integer limit, String fuzzy);
}
