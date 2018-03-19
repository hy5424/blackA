package com.lc.hb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.common.constants.ErrorCodeConstants;
import com.lc.hb.response.MsgResponse;
import com.lc.hb.service.CommonUserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource(name = "commonUserService")
    CommonUserService commonUserService;

    @ResponseBody
    @RequestMapping(value = "/registerA0100", method = RequestMethod.POST, produces = {
            "application/json;charset=utf-8" })
    public String register(HttpServletRequest request, @RequestParam(required = true) String loginName,
            @RequestParam(required = true) String password, @RequestParam(required = true) String sex) {
        try {
            logger.info("[用户注册] 开始......");
            logger.info("[用户注册] 用户名：" + loginName);
            logger.info("[用户注册] 密码：" + password);

            String resp = commonUserService.register(loginName, password, sex);

            logger.info("[用户注册] 返回信息：" + resp);

            return resp;
        } catch (Exception e) {
            logger.error("注册异常：", e);
            return MsgResponse.packMsg(ErrorCodeConstants.E9999, "注册异常！");
        }
    }

}
