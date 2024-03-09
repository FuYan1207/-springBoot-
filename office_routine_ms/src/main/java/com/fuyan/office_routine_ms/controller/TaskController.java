package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.pojo.Task;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.servcie.TaskService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/work")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 获取所有任务,并返回对应数据结构
     * @return
     */
    @PostMapping("/list")
    public Result<List<TaskListInfo>> TaskList(@RequestBody Employee employee){
        List<Task> taskList = taskService.taskList(employee.getEmployeeId());
        List<TaskListInfo> taskListInfoList = new ArrayList<>();
        TaskListInfo taskListInfo1 = new TaskListInfo();//未开始
        taskListInfo1.setName("未开始");
        List<Children> children1 = new ArrayList<>();
        taskListInfo1.setChildren(children1);

        TaskListInfo taskListInfo2 = new TaskListInfo();//进行中
        taskListInfo2.setName("进行中");
        List<Children> children2 = new ArrayList<>();
        taskListInfo2.setChildren(children2);

        TaskListInfo taskListInfo3 = new TaskListInfo();//已完成
        taskListInfo3.setName("已完成");
        List<Children> children3 = new ArrayList<>();
        taskListInfo3.setChildren(children3);

        for (Task task:taskList) {
            //获取任务状态
            String name = task.getStatus();
            Children children = new Children();
            //获取当前任务信息
            children.setId(task.getTaskId());
            children.setTaskContent(task.getTaskContent());
            if (task.getResponsiblePerson()==task.getPublisher()){
                children.setTags("me");
            }else {
                children.setTags("boss");
            }
            String options = employeeService.findEmployeeNameById(task.getResponsiblePerson());
            children.setOptions(options);
            if (name.equals("未开始")){
                taskListInfo1.getChildren().add(children);
            } else if (name.equals("进行中")) {
                taskListInfo2.getChildren().add(children);
            } else if (name.equals("已完成")){
                taskListInfo3.getChildren().add(children);
            }
        }

        taskListInfoList.add(taskListInfo1);
        taskListInfoList.add(taskListInfo2);
        taskListInfoList.add(taskListInfo3);
        return Result.success(taskListInfoList);
    }

    /**
     * 更新任务状态
     * @param updateInfo
     * @return
     */
    @PutMapping("/updateStatus")
    public Result update(@RequestBody UpdateInfo updateInfo){
        taskService.updateStatus(updateInfo.taskId,updateInfo.toStatus);
        return Result.success();
    }


    /**
     * 添加任务
     * @param task
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Task task){
        taskService.add(task);
        return Result.success();
    }

    /**
     * 获取已经完成的任务数
     * @param employee
     * @return
     */
    @PostMapping("/count")
    public Result<Integer> count(@RequestBody Employee employee){
        Integer count = taskService.count(employee.getEmployeeId());
        return Result.success(count);
    }

    @Data
    static class UpdateInfo{
        private Integer taskId;
        private String toStatus;
    }

    @Data
    public class TaskListInfo{
        private String name;
        private List<Children> children;
    }

    @Data
    public class Children{
        private Integer id;
        private String tags;
        private String taskContent;
        private String options;
    }
}
