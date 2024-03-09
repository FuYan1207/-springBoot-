package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.EmployeeMapper;
import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.PageBean;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public PageBean<Employee> employeeList(Integer page,Integer pageSize,String input) {
        PageBean<Employee> pb = new PageBean<>();
        PageHelper.startPage(page,pageSize);
        List<Employee> employeeList = employeeMapper.getAll(input);
        Page<Employee> p = (Page<Employee>)employeeList;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.add(employee);
    }

    @Override
    public void deleteEmployeeById(List<Integer> ids) {
        employeeMapper.delete(ids);
    }

    @Override
    public int getEmployeeIdByNameContactInfo(String name, String contactInfo) {
        int id = employeeMapper.getId(name,contactInfo);
        return id;
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public String findEmployeeNameById(Integer employeeId) {
        return employeeMapper.findEmployeeNameById(employeeId);
    }

    @Override
    public Integer count() {
        return employeeMapper.count();
    }

    @Override
    public List<Employee> nameList(Integer employeeId) {
        return employeeMapper.getNames(employeeId);
    }


}
