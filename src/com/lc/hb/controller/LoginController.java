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
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "commonUserService")
    CommonUserService commonUserService;

    @ResponseBody
    @RequestMapping(value = "/loginA0100", method = RequestMethod.POST, produces = {"application/json;charset=utf-8" })
    public String login(HttpServletRequest request, @RequestParam(required = true) String loginName,
            @RequestParam(required = true) String password) {

        try {
            logger.info("[用户登录] 开始......");
            logger.info("[用户登录] 用户名：" + loginName);
            logger.info("[用户登录] 密码：" + password);

            String resp = commonUserService.login(loginName, password);

            logger.info("[用户登录] 返回信息：" + resp);

            return resp;
        } catch (Exception e) {
            logger.error("登录异常：", e);
            return MsgResponse.packMsg(ErrorCodeConstants.E9999, "登录异常！");
        }

    }

}
