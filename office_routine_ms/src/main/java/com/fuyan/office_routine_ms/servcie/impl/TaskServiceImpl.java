package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.TaskMapper;
import com.fuyan.office_routine_ms.pojo.Task;
import com.fuyan.office_routine_ms.servcie.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;
    @Override
    public List<Task> taskList(Integer employeeId) {
        List<Task> taskList = taskMapper.getAll(employeeId);
        return taskList;
    }

    @Override
    public void updateStatus(Integer taskId, String toStatus) {
        taskMapper.updataStatus(taskId,toStatus);
    }

    @Override
    public void add(Task task) {
        taskMapper.add(task);
    }

    @Override
    public Integer count(Integer id) {
        return taskMapper.count(id);
    }
}
