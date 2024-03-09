package com.fuyan.office_routine_ms.webSocket;


import com.fuyan.office_routine_ms.servcie.ChatService;
import com.fuyan.office_routine_ms.utils.RedisUtils;
import com.fuyan.office_routine_ms.webSocket.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * 定时任务
 */
@Service
public class scheduleService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChatService chatService;

    @Scheduled(cron = "0/40 * * * * ?")
    public void saveMessage(){
        //将总消息池的消息保存到数据库
        List<Message> messageList = redisUtils.listRange("newMessage:all",0,-1);
        if (messageList != null && messageList.size() != 0 ){
            chatService.insertChattingRecords(messageList);
        }
        //清楚总消息池
        redisUtils.remove("newMessage:all");
        Set<String> keys = redisUtils.keys("oldMessage:*");
        //清楚旧消息池
        if(keys!=null){
            redisTemplate.delete(keys);
        }
        //清除新群消息池
        redisUtils.remove("newMessage:group");


    }
}
