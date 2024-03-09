package com.fuyan.office_routine_ms.webSocket.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Message {
    private Integer id;
    private Integer fromWho;
    private Integer toWho;
    private String text;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date;
}
