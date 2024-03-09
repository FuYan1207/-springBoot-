package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.pojo.Task;

import java.util.List;

public interface TaskService {
    List<Task> taskList(Integer employeeId);

    void updateStatus(Integer taskId, String toStatus);

    void add(Task task);

    Integer count(Integer id);
}
