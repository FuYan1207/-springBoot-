package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 考勤表
 */
@Data
public class AttendanceRecord {
    private Integer recordId;
    private Integer userId;
    private LocalDate date;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String status;
}
