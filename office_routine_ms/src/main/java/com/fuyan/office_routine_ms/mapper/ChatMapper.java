package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.webSocket.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {
    void insert(List<Message> messages) ;

    List<Message> getChattingRecordsById(Integer employeeId);
}
