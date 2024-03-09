package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.servcie.ChatService;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.utils.RedisUtils;
import com.fuyan.office_routine_ms.webSocket.WebSocketServer;
import com.fuyan.office_routine_ms.webSocket.pojo.Message;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ChatService chatService;

    @Autowired
    private RedisUtils redisUtils;


    /**
     * 获取当前在线用户
     * @param employee
     * @return
     */
    @PostMapping("/onlineUserList")
    public Result<Set<Integer>>onlineUser(@RequestBody Employee employee){
        ConcurrentHashMap<Integer, Session> map = WebSocketServer.getSessionPools();
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        Set<Integer> nameset = new HashSet<Integer>();
        while (it.hasNext()) {
            Integer entry = it.next();
            if (!entry.equals(employee.getEmployeeId()))
                nameset.add(entry);
        }
        return Result.success(nameset);
    }


    @PostMapping("/chattingRecords")
    public Result<List<Message>> getChattingRecords(@RequestBody Employee employee){
        //获取redis里的数据
        List<Message> messagesRedis = redisUtils.listRange("oldMessage:"+employee.getEmployeeId(),0,-1);
        List<Message> groupMessageRedis = redisUtils.listRange("newMessage:group",0,-1);
        //获取数据库里的消息
        List<Message> messages = chatService.getChattingRecords(employee.getEmployeeId());
        messages.addAll(messagesRedis);
        messages.addAll(groupMessageRedis);
        return Result.success(messages);
    }



}
