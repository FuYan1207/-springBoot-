package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * 会议表
 */
@Data
public class Meetings {
    private Integer meetingId;
    private String meetingTopic;
    private String participants;
    private LocalDateTime meetingDate;
    private String meetingPlace;
    private String president;
}
