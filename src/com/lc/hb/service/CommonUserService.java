package com.lc.hb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lc.common.constants.ErrorCodeConstants;
import com.lc.common.util.JSONUtil;
import com.lc.entity.CommonUser;
import com.lc.hb.dao.CommonUserDao;
import com.lc.hb.response.MsgResponse;

@Repository("commonUserService")
public class CommonUserService {

    private static Logger logger = LoggerFactory.getLogger(CommonUserService.class);

    @Resource(name = "commonUserDao")
    private CommonUserDao commonUserDao;

    /**
     * @Description (登录)
     * @param userName
     * @param password
     * @return
     */
    public String login(String userName, String password) throws Exception {
        // 根据用户名查找用户
        CommonUser commonUser = commonUserDao.getUserByName(userName);
        if (commonUser == null) {
            return MsgResponse.packMsg(ErrorCodeConstants.E0101, "用户名不存在！");
        }
        if (!password.equals(commonUser.getPwd())) {
            return MsgResponse.packMsg(ErrorCodeConstants.E0102, "密码不正确！");
        }

        MsgResponse response = new MsgResponse();
        response.setCode(ErrorCodeConstants.SECCESS);
        response.setMsg("登陆成功");

        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("userId", String.valueOf(commonUser.getId()));
        responseMap.put("sex", commonUser.getSex());
        responseMap.put("status", commonUser.getStatus());

        response.setResponse(responseMap);

        String retJson = JSONUtil.packJson(response);
        return retJson;
    }

    @Transactional
    public String register(String userName, String password, String sex) throws Exception {
        // 根据用户名查找用户
        CommonUser commonUser = commonUserDao.getUserByName(userName);
        if (commonUser != null) {
            return MsgResponse.packMsg(ErrorCodeConstants.E0103, "用户名已存在！");
        }

        CommonUser commonUserNew = new CommonUser();
        commonUserNew.setId(generateMercId());
        commonUserNew.setName(userName);
        commonUserNew.setPwd(password);
        commonUserNew.setStatus("1");
        commonUserNew.setSex(Integer.valueOf(sex));
        commonUserDao.save(commonUserNew);

        MsgResponse response = new MsgResponse();
        response.setCode(ErrorCodeConstants.SECCESS);
        response.setMsg("注册成功");

        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("userId", String.valueOf(commonUserNew.getId()));
        responseMap.put("sex", commonUserNew.getSex());
        responseMap.put("status", commonUserNew.getStatus());

        response.setResponse(responseMap);

        String retJson = JSONUtil.packJson(response);
        return retJson;
    }

    /**
     * @return
     */
    public static Long generateMercId() {

        Random rand = new Random();
        int mr = rand.nextInt(8999) + 1000;
        long tm = System.currentTimeMillis();
        // 商编Id
        Long mercId = tm + mr;
        return mercId;
    }
}
