package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.Result;
import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.utils.JwtUtil;
import com.fuyan.office_routine_ms.utils.ThreadLocalUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private UserController userController;

    @Test
    public void registerTest(){
        Result result = userController.register("root","root");
        System.out.println(result);
    }

    @Test
    public void loginTest(){
        UserController.LoginInfo loginInfo = new UserController.LoginInfo();
        loginInfo.setUsername("root");
        loginInfo.setPassword("root");
        Result result = userController.login(loginInfo);
        System.out.println(result);
    }

    @Test
    public void updatePasswordTest(){

    }

    @Test
    public void userInfoTest(){

    }


    @Test
    public void delUserByIdTest(){
        List<Integer> ids = new ArrayList<>();
        ids.add(1);ids.add(2);
        Result result = userController.delUserById(ids);
        System.out.println(result);
    }

}
