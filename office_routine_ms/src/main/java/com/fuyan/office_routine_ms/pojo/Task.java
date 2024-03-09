package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

import java.time.LocalDate;


/**
 * 任务表
 */
@Data
public class Task {
    private Integer taskId;
    private String taskContent;
    private Integer responsiblePerson;
    private LocalDate deadline;
    private String status;
    private Integer publisher;
}
