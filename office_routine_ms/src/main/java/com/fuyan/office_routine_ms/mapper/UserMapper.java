package com.fuyan.office_routine_ms.mapper;

import com.fuyan.office_routine_ms.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findByUsername(String username);

    void add(String username, String password, String permission,int employeeId);

    void updatePermission(String permission,int id);

    void updatePassword(String newPwd,int id);

    List<User> getAll(String input);

    void delete(List<Integer> ids);

    void updateStarus(Integer userId, String status);
}
