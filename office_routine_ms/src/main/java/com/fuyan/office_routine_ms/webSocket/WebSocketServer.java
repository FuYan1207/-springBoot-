package com.fuyan.office_routine_ms.webSocket;

import com.alibaba.fastjson.JSON;
import com.fuyan.office_routine_ms.servcie.ChatService;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.utils.RedisUtils;
import com.fuyan.office_routine_ms.webSocket.pojo.Message;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/webSocket/{employeeId}")
@Component
public class WebSocketServer {
	 //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<Integer, Session> sessionPools = new ConcurrentHashMap<>();

    private  static EmployeeService employeeService;
    @Autowired
    public void setEmployeeService(EmployeeService employeeService){
        WebSocketServer.employeeService = employeeService;
    }

    private static RedisUtils redisUtils;
    @Autowired
    public void setRedisUtils(RedisUtils redisUtils){
        WebSocketServer.redisUtils = redisUtils;
    }

    private static ChatService chatService;
    @Autowired
    public void setChatService(ChatService chatService){
        WebSocketServer.chatService = chatService;
    }

    public static final int ALL_USER = -3; //所有人
    public static final int SYSTEM_CONNECT_OPEN = -2; //系统消息

    public static final int SYSTEM_CONNECT_CLOSE = -4;

    //给指定会话发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }

    // 给在线的人群发消息
    public void broadcast(Message message,Integer fromName){
    	for (Integer toName: sessionPools.keySet()) {//依次给每个会话发送消息
            try {
                if (toName != fromName){//过滤自己
                    Session session = sessionPools.get(toName);
                    String msg = JSON.toJSONString(message);
                    sendMessage(session, msg);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        //发送的不是系统消息,就将这条消息放入群消息池和总消息池
        if (message.getFromWho() != SYSTEM_CONNECT_OPEN && message.getFromWho() != SYSTEM_CONNECT_CLOSE){
            redisUtils.listRightPush("newMessage:group",message);
            redisUtils.listRightPush("newMessage:all",message);
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam("employeeId") Integer employeeId){
        sessionPools.put(employeeId, session);//会话加入会话池
        addOnlineCount();//在线人数加一
        System.out.println("Id为"+ employeeId + "的用户加入webSocket！当前人数为" + onlineNum);
        // 广播上线消息
        String name;
        if (employeeId == -1){
            name = "管理员";
        }else {
            name = employeeService.findEmployeeNameById(employeeId);
        }
        Message msg = new Message();
        msg.setDate(new Date());
        msg.setFromWho(SYSTEM_CONNECT_OPEN);
        msg.setToWho(ALL_USER);
        msg.setText(name);
        broadcast(msg,employeeId);//依次给每个会话发送消息

        //获取离线时未收到个人的消息
        List<Message> newMessages = redisUtils.listRange("newMessage:"+employeeId,0,-1);
        for (Message message:newMessages){
            try{
                //将消息发送给自己
                sendMessage(session,JSON.toJSONString(message));
                redisUtils.listLeftPop("newMessage:"+employeeId);//移出此条新消息
                redisUtils.listRightPush("oldMessage:"+employeeId,message);//将这条消息加入老消息池
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    //关闭连接时调用
    @OnClose
    public void onClose( @PathParam("employeeId") Integer employeeId){
        sessionPools.remove(employeeId);
        subOnlineCount();
        System.out.println("Id为"+ employeeId + "的用户断开webSocket！当前人数为" + onlineNum);
        // 广播下线消息
        String name;
        if (employeeId == -1){
            name = "管理员";
        }else {
            name = employeeService.findEmployeeNameById(employeeId);
        }
        Message msg = new Message();
        msg.setDate(new Date());
        msg.setFromWho(SYSTEM_CONNECT_CLOSE);
        msg.setToWho(ALL_USER);
        msg.setText(name);
        broadcast(msg,employeeId);


    }



    //收到客户端信息后，根据接收人的id把消息推下去或者群发
    @OnMessage
    public void onMessage(String message,@PathParam("employeeId") Integer employeeId3) throws IOException{
        System.out.println("server get" + message);
        Message msg=JSON.parseObject(message, Message.class);
		msg.setDate(new Date());
        Integer employeeId =  msg.getFromWho();
		if (msg.getToWho().equals(ALL_USER)) {  //将消息发给所有人
			broadcast(msg,employeeId);
		} else {
            Integer employeeId1 = msg.getToWho();
            Session session = sessionPools.get(employeeId1); //查找对应的会话
            try {
                //如果用户不在线，就先将消息存到redis的newMessages中
                if (session == null){
                    //将消息存到接收方的新消息池
                    redisUtils.listRightPush("newMessage:"+employeeId1,msg);
                    //将消息存到自己的老消息池
                    redisUtils.listRightPush("oldMessage:"+employeeId3,msg);
                    //将消息存到总消息池
                    redisUtils.listLeftPush("newMessage:all",msg);

                }else {
                    sendMessage(session, message);
                    //将消息存到接收方的新消息池
                    redisUtils.listRightPush("oldMessage:"+employeeId1,msg);
                    //将消息存入旧消息池
                    redisUtils.listRightPush("oldMessage:"+employeeId3,msg);
                    //将消息存入总消息池
                    redisUtils.listRightPush("newMessage:all",msg);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
		}
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    //添加用户数量 
    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }
    //减少用户数量 
    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }
    //当前在线人数
    public static AtomicInteger getOnlineNumber() {
        return onlineNum;
    }
    //获取会话池
    public static ConcurrentHashMap<Integer, Session> getSessionPools() {
        return sessionPools;
    }

}
