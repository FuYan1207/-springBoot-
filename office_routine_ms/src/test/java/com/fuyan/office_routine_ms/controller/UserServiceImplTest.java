package com.fuyan.office_routine_ms.controller;

import com.fuyan.office_routine_ms.pojo.User;
import com.fuyan.office_routine_ms.servcie.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findByUsername(){
        User user = userService.findByUsername("root");
        System.out.println(user);
    }


}
