package com.fuyan.office_routine_ms.servcie.impl;

import com.fuyan.office_routine_ms.mapper.UserMapper;
import com.fuyan.office_routine_ms.pojo.Employee;
import com.fuyan.office_routine_ms.pojo.PageBean;
import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.servcie.UserService;
import com.fuyan.office_routine_ms.utils.Md5Util;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }
    @Override
    public void register(String username, String password) {
        String permission = "普通用户";
        //加密密码
        String md5Password = Md5Util.getMD5String(password);
        //当employeeId为-1标志着该账号没有绑定员工
        userMapper.add(username,md5Password,permission,-1);
    }
    @Override
    public void register(String username, String password,int employeeId) {
        String permission = "普通用户";
        //加密密码
        String md5Password = Md5Util.getMD5String(password);
        userMapper.add(username,md5Password,permission,employeeId);
    }

    @Override
    public void updatePermission(String permission,int id) {
        userMapper.updatePermission(permission,id);
    }

    @Override
    public void updatePassword(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        int id = (int) map.get("id");
        userMapper.updatePassword(Md5Util.getMD5String(newPwd),id);
    }

    @Override
    public PageBean<User> listUser(Integer page, Integer pageSize, String input) {
        PageBean<User> pb = new PageBean<>();
        PageHelper.startPage(page,pageSize);
        List<User> userList  = userMapper.getAll(input);
        Page<User> p = (Page<User>)userList;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public void delUserById(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public void logout(String token) {
        //删除redis中的值
        stringRedisTemplate.delete(token);
        //清楚线程里的数据
        ThreadLocalUtil.remove();
    }

    @Override
    public void updateStatus(Integer userId, String status) {
        userMapper.updateStarus(userId,status);
    }
}
