package com.controller;

import com.constant.CommonConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangjingyuan
 * @Date: 2020/3/27 13:15
 */
@RestController
public class CommonController {
    
    @RequestMapping("/message")
    public String getMessage() {
        return CommonConstant.MESSAGE;
    }
}
