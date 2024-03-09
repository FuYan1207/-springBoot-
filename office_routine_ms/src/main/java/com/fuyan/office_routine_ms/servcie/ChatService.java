package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.webSocket.pojo.Message;

import java.util.List;

public interface ChatService {
    List<Message> getChattingRecords(Integer employeeId);

    void insertChattingRecords(List<Message> Messages);
}
