package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface EmployeeMapper {
    List<Employee> getNames(Integer employeeId);

    List<Employee> getAll(String input);

    void add(Employee employee);

    void delete(List<Integer> ids);

    int getId(String name, String contactInfo);

    void update(Employee employee);

    String findEmployeeNameById(Integer employeeId);

    Integer count();
}
