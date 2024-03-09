package com.fuyan.office_routine_ms.controller;

import cn.hutool.core.lang.UUID;
import com.fuyan.office_routine_ms.pojo.PageBean;
import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.servcie.EmployeeService;
import com.fuyan.office_routine_ms.servcie.UserService;
import com.fuyan.office_routine_ms.utils.Md5Util;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import com.mysql.cj.util.StringUtils;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;

    //redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     *注册用户
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public Result<String> register(String username,String password){
        User user = userService.findByUsername(username);
        if (user == null){
            userService.register(username,password);
            return Result.success("注册成功");
        }else {
            return Result.error("用户名已经存在");
        }
    }

    /**
     * 登入用户，返回token
     * @param loginInfo
     * @return
     */
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginInfo loginInfo){
        User loginUser =userService.findByUsername(loginInfo.username);
        //判断用户名是否正确
        if (loginUser == null) return Result.error("用户名错误");
        if (loginUser.getStatus().equals("0")) return Result.error("账号被冻结");
        //判断密码是否正确
        if (Md5Util.getMD5String(loginInfo.password).equals(loginUser.getPassword())){
            //生成随机token，用于登入认证
            String token = UUID.randomUUID().toString(true);
            //将user对象转换为HashMap
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getUserId().toString());
            claims.put("username",loginUser.getUsername());
            //存储到redis中
            stringRedisTemplate.opsForHash().putAll(token,claims);
            //设置有效期
            stringRedisTemplate.expire("login"+token,60, TimeUnit.MINUTES);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    /**
     * 退出登入
     * @param token
     * @return
     */
    @PostMapping("/logout")
    public Result logout(@RequestBody String token){
        userService.logout(token);
        return Result.success("退出成功");
    }


    /**
     * 根据员工id删除用户
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result delUserById(List<Integer> ids){
        userService.delUserById(ids);
        return Result.success();
    }

    /**
     * 获取当前登入用户信息
     * @return
     */
    @GetMapping("/info")
    public Result<UserInfo> userInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUsername(username);
        String name;
        if (user.getEmployeeId() != -1){
            name = employeeService.findEmployeeNameById(user.getEmployeeId());
        }else {
            name = "管理员";
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfo.setName(name);
        return Result.success(userInfo);
    }

    /**
     * 获取全部用户
     * @return
     */
    @PostMapping("/list")
    public Result<PageBean<User>> userList(@RequestBody EmployeeController.Page pageBean){
        PageBean<User> userList = userService.listUser(pageBean.getPage(),pageBean.getPageSize(), pageBean.getInput());
        return Result.success(userList);
    }

    /**
     * 修改权限
     * @param permissionInfo
     * @return
     */
    @PatchMapping("/updatePermission")
    public Result updatePermission(@RequestBody PermissionInfo permissionInfo){
        userService.updatePermission(permissionInfo.permission,permissionInfo.userId);
        return Result.success();
    }

    /**
     * 更新账户状态
     * @param statusInfo
     * @return
     */
    @PatchMapping("/updateStatus")
    public Result updateStatus(@RequestBody StatusInfo statusInfo){
        userService.updateStatus(statusInfo.userId,statusInfo.status);
        return Result.success();
    }

    /**
     * 修改密码
     * @param params
     * @return
     */
    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String,String> params){
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (StringUtils.isNullOrEmpty(oldPwd) || StringUtils.isNullOrEmpty(newPwd) || StringUtils.isNullOrEmpty(rePwd)){
            return Result.error("缺少必要的参数");
        }
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User loginUSer = userService.findByUsername(username);
        if (!loginUSer.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码不正确");
        }

        if (!newPwd.equals(rePwd)){
            Result.error("两次填写的新密码不一样");
        }

        userService.updatePassword(newPwd);
        return Result.success();
    }

    @Data
    static class LoginInfo{
        private String username;
        private String password;
    }

    @Data
    static class StatusInfo{
        private Integer userId;
        private String status;
    }

    @Data
    static class PermissionInfo{
        private Integer userId;
        private String permission;
    }

    @Data
    class UserInfo{
        private User user;
        private String name;
    }

}
