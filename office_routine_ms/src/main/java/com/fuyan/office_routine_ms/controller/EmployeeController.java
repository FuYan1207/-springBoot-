package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.PageBean;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.servcie.UserService;
import com.fuyan.office_routine_ms.utils.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;

    /**
     * 获取员工列表（分页）
     * @return
     */
    @PostMapping("/list")
    public Result<PageBean<Employee>> employeeList(@RequestBody Page  pageBean){
        PageBean<Employee> employeeList = employeeService.employeeList(pageBean.page,pageBean.pageSize,pageBean.input);
        return Result.success(employeeList);
    }

    /**
     * 获取所有员工信息（不分页）
     * @param employee
     * @return
     */
    @PostMapping("/names")
    public  Result<List<Employee>> getNames(@RequestBody Employee employee){
        List<Employee> employees = employeeService.nameList(employee.getEmployeeId());
        return Result.success(employees);
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @PostMapping("/add")
    @Transactional//添加事务
    public Result addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        //添加用户的同时自动创建用户
        String employeeName = employee.getName();
        String username = StringUtils.toFirstChar(employeeName)+employee.getContactInfo();
        String password = StringUtils.toPinyin(employeeName)+"@fuyan";
        Result<Integer> result = this.getEmployeeIdByNameContactInfo(employee.getName(),employee.getContactInfo());
        int id = result.getData();
        userService.register(username,password,id);
        return Result.success();
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Employee employee){
        employeeService.update(employee);
        return Result.success();
    }

    /**
     * 根据员工id删除员工与用户
     * @param ids
     * @return
     */
    @DeleteMapping
    @Transactional//添加事务
    public Result deleteEmployeeById(@RequestBody LinkedHashMap ids){
        String str = (String)ids.get("ids");
        String[] parts =  str.split(",");
        List<Integer> integers = new ArrayList<>();
        for (String part : parts) {
            try {
                integers.add(Integer.parseInt(part));
            } catch (NumberFormatException e) {
                // 处理无法转换为整数的情况
                System.err.println("Error: Cannot convert " + part + " to an integer.");
            }
        }
        employeeService.deleteEmployeeById(integers);
        //删除员工后同时删除账户
        userService.delUserById(integers);
        return Result.success();
    }

    /**
     * 根据员工姓名与联系方式获取id
     * @param name
     * @param contactInfo
     * @return
     */
    @GetMapping("/id")
    public Result<Integer> getEmployeeIdByNameContactInfo(String name,String contactInfo){
        int id = employeeService.getEmployeeIdByNameContactInfo(name,contactInfo);
        return Result.success(id);
    }

    /**
     * 获取员工数
     * @return
     */
    @GetMapping("/count")
    public  Result<Integer> count(){
        Integer count = employeeService.count();
        return Result.success(count);
    }

    @Data
    static class Page{
        private String input;
        private Integer page;
        private Integer pageSize;
    }


}
