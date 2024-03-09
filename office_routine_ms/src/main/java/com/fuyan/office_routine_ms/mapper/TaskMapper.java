package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.pojo.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Task> getAll(Integer employeeId);

    void updataStatus(Integer taskId, String toStatus);

    void add(Task task);

    Integer count(Integer id);
}
