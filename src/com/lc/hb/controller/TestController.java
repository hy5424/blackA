package com.lc.hb.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping(value = "/fff", method = RequestMethod.GET, produces = {"application/json;charset=utf-8" })
    public String help1List(HttpServletRequest request) {
        try {
            logger.info("测试");
            System.out.println("测试");
            return "测试";
        } catch (Exception e) {
            logger.error("系统错误", e);
        }
        return "测试";
    }

}
