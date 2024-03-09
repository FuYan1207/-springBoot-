package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.PageBean;

import java.util.List;

public interface EmployeeService {
    PageBean<Employee> employeeList(Integer pageIndex, Integer pageSize,String input);

    void addEmployee(Employee employee);

    void deleteEmployeeById(List<Integer> ids);

    int getEmployeeIdByNameContactInfo(String name, String contactInfo);

    void update(Employee employee);

    String findEmployeeNameById(Integer employeeId);

    Integer count();

    List<Employee> nameList(Integer employeeId);
}
