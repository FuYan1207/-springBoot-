package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * 公告表
 */
@Data
public class Announcements {
    private Integer announcementId;
    private String title;
    private String content;
    private Integer publisher;
    private LocalDate publishDate;
}
