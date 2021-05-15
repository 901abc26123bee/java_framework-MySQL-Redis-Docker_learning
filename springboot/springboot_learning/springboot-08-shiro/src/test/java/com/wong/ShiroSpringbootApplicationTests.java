package com.wong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wong.service.UserService;

@SpringBootTest
class ShiroSpringbootApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("lala"));
        // User(id=4, name=lala, pwd=58809, perms=null)
    }

}
