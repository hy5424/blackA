package com.lc.hb.controller;

import java.util.List;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lc.hb.core.DealCard;

@Controller
@RequestMapping("/Chess")
public class DealController {

    private static Logger log = LoggerFactory.getLogger(DealController.class);

    @ResponseBody
    @RequestMapping(value = "/deal", method = RequestMethod.POST, produces = {"application/json;charset=utf-8" })
    public String help1List(HttpServletRequest request) {
        String result = "";
        try {
            // String tableId = request.getParameter("tableId");
            // 根据tableId 查询在房间里面的4个用户
            log.info("开始进行洗牌发牌......");
            // 请求洗牌发牌
            List<TreeSet<Integer>> chess = DealCard.getPock();
            System.out.println(chess);

        } catch (Exception e) {
            log.error("系统错误", e);
        }
        return result;
    }

}
