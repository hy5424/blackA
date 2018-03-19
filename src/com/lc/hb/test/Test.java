package com.lc.hb.test;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

import com.lc.common.util.HttpClientUtils;
import com.lc.hb.request.MsgRequest;

import io.netty.channel.ConnectTimeoutException;
import net.sf.json.JSONObject;

public class Test {

    @org.junit.Test
    public void testRegister() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginName", "lcy");
        map.put("password", "1");
        map.put("sex", "1");
        String json = JSONObject.fromObject(map).toString();
        System.out.println(json);
        String ret = sendMsg(json, "http://localhost:8081/blackA/register/registerA0100");
        System.out.println(ret);
    }

    public static String sendMsg(String json, String url) {
        String ret = null;
        try {
            ret = HttpClientUtils.postForm(url, json, HttpClientUtils.connTimeout, HttpClientUtils.readTimeout);
        } catch (ConnectTimeoutException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
