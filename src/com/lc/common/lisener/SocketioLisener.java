package com.lc.common.lisener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lc.hb.core.DealCard;
import com.lc.hb.core.IsBigger;
import com.lc.hb.request.MsgRequest;

import net.sf.json.JSONObject;

@ServerEndpoint("/websocket")
public class SocketioLisener {

    private static final Logger log = LoggerFactory.getLogger(SocketioLisener.class);

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static Map<String, SocketioLisener> webSocketSet = new HashMap<String, SocketioLisener>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     * 
     * @param session
     *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        // webSocketSet.add(this); // 加入set中
        // addOnlineCount(); // 在线数加1
        // System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     * 
     * @param message
     *            客户端发送过来的消息
     * @param session
     *            可选的参数
     */
    @SuppressWarnings("unchecked")
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            log.info("接收到的参数：" + message);

            MsgRequest msgRequest = (MsgRequest) JSONObject.toBean(JSONObject.fromObject(message), MsgRequest.class);
            String code = msgRequest.getCode();
            Map<String, Object> request = msgRequest.getRequest();
            switch (code) {
            // 前端示例 {"code":"ready",request:{"userId":"1000"}}
            case "ready":
                webSocketSet.put(request.get("userId").toString(), this); // 客户端准备好后，把用户传过来的msg:用户编号作为用户标识
                addOnlineCount(); // 增加当前在线人数
                session.getBasicRemote().sendText(String.valueOf(getOnlineCount())); // 给这个用户发送编号以进行排序

                if (getOnlineCount() == 4) {
                    Map<String, String> responseMap = new HashMap<String, String>();
                    List<TreeSet<Integer>> deal = DealCard.getPock();
                    Set<String> userIds = webSocketSet.keySet();

                    int i = 0;
                    for (String string : userIds) {
                        responseMap.put("msg", deal.get(i).toString());
                        webSocketSet.get(string).sendMessage(responseMap.toString());
                        i++;
                    }
                }
                break;
            // 前端示例 {"code":"play",request:{"last":[51,52,53],"theCards":[61,62,63]}}
            case "play":
                ArrayList<Integer> lastList = (ArrayList<Integer>) request.get("last");// 上级出的牌
                ArrayList<Integer> theCardsList = (ArrayList<Integer>) request.get("theCards");// 自己出的牌

                TreeSet<Integer> lastTree = new TreeSet<Integer>();
                lastTree.addAll(lastList);

                TreeSet<Integer> theCardsTree = new TreeSet<Integer>();
                theCardsTree.addAll(theCardsList);

                // 比较大小
                boolean flag = IsBigger.IsBiggerThanLast(lastTree, theCardsTree);
                session.getBasicRemote().sendText(String.valueOf(flag));

                break;
            default:
                break;
            }
        } catch (Exception e) {
            log.error("系统异常", e);
        }
    }

    /**
     * 发生错误时调用
     * 
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * 
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        SocketioLisener.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        SocketioLisener.onlineCount--;
    }
}
