package com.fuyan.office_routine_ms.pojo;

import lombok.Data;

import java.time.LocalDate;
/**
 * 员工表
 */
@Data
public class Employee {
    private Integer employeeId;
    private String name;
    private String position;
    private String contactInfo;
    private LocalDate hireDate;
    private String gender;
    private Integer age;
}
