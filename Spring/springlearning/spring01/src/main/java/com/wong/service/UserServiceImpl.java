package com.wong.service;

import com.wong.dao.UserDao;

public class UserServiceImpl implements UserService {
    // private UserDao userDao = new UserDaoImpl();
    // private UserDao userDao = new UserDaoMySqlImpl();
	private UserDao userDao ;
	
	// 利用set進行動態實現值
	public void setUserDao(UserDao userDao) {
	    this.userDao = userDao;
	}
    @Override
    public void getUser() {
       userDao.getUser();
  }
}
