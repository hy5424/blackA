package com.lc.hb.test;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.lc.common.lisener.SocketioLisener;

public class LcyTest {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.setHostname("127.0.0.1");
        config.setPort(Integer.parseInt("8088"));
        SocketIOServer server = new SocketIOServer(config);

        SocketioLisener socketListener = new SocketioLisener(server);

        // 客户端连接上时触发
        server.addConnectListener(socketListener);

        // 监听客户端消息
        // 工单产品执行监控表头数据，只发一次，需要由客户端请求后发送
        server.addEventListener("testMessage", String.class, socketListener);

        // 客户断连接断开时触发
        server.addDisconnectListener(socketListener);
        // 启动服务
        server.start();
    }
}
