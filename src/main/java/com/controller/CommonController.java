package com.controller;

import com.config.Global;
import com.constant.CommonConstant;
import com.util.file.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 13:15
 */
@RestController
public class CommonController {
    private static Logger logger = LoggerFactory.getLogger(CommonController.class);


    @RequestMapping("/message")
    public String getMessage() {
        logger.info("开始测试");
        return CommonConstant.MESSAGE;
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download")
    public void resourceDownload(@RequestParam("resource") String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath +"/"+"download/"+resource;
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        response.setCharacterEncoding("utf-8");
        response.setContentType("UTF-8");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }
}
