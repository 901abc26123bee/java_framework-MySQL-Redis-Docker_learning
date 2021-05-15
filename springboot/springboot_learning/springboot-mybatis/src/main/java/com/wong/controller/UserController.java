package com.wong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wong.mapper.UserMapper;
import com.wong.pojo.User;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        return userList;
    }

    //添加一個用戶
    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(7,"阿毛","123456"));
        return "ok";
    }

    //修改一個用戶
    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(7,"阿毛","123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(7);

        return "ok";
    }
}