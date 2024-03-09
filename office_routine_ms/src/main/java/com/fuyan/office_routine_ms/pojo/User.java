package com.fuyan.office_routine_ms.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

/**
 * 用户表
 */
@Data
public class User {
    private Integer userId;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//让springmvc把当前对象转换成json字符串时候，忽略掉
    private String password;
    private Integer employeeId;
    private LocalDate createDate;
    private String permission;
    private String status;
}
