package com.fuyan.office_routine_ms.servcie;

import com.fuyan.office_routine_ms.pojo.PageBean;
import com.fuyan.office_routine_ms.pojo.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    void register(String username, String password);
    void register(String username, String password,int employeeId);

    void updatePermission(String permission,int id);

    void updatePassword(String newPwd);

    PageBean<User> listUser(Integer page, Integer pageSize, String input);

    void delUserById(List<Integer> ids);

    void logout(String token);

    void updateStatus(Integer userId, String status);
}
