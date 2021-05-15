package com.wong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.wong.pojo.User;

//這個註解表示了這是一個 mybatis 的 mapper 類
@Mapper
@Repository
// @Repository註解在持久層中，具有將數據庫操作拋出的原生異常翻譯轉化為spring的持久層異常的功能。
public interface UserMapper {
	public static final int constantVariable = 5;

	List<User> queryUserList();

	User queryUserById(int id);

	int addUser(User user);

	int updateUser(User user);

	int deleteUser(int id);
}