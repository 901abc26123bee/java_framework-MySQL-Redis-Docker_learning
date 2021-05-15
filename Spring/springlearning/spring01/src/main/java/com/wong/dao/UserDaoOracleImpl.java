package com.wong.dao;

public class UserDaoOracleImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("Oracle獲取用戶數據");
  }
}