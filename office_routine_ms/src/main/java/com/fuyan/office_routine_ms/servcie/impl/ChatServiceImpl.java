package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.ChatMapper;
import com.fuyan.office_routine_ms.servcie.ChatService;
import com.fuyan.office_routine_ms.webSocket.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<Message> getChattingRecords(Integer employeeId) {
        return chatMapper.getChattingRecordsById(employeeId);
    }

    @Override
    public void insertChattingRecords(List<Message> messages) {
        chatMapper.insert(messages);
    }
}
