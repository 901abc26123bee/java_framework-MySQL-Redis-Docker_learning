package com.wong.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wong.pojo.User;

@Repository
@Mapper
public interface UserMapper {

    public User queryUserByName(String name);
}