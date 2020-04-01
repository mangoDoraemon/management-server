package com.controller;

import com.constant.CommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
