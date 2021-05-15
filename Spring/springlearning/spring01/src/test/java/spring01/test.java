package spring01;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.service.UserServiceImpl;



public class test {
	@Test
	public void test2() {
		// 獲取 ApplicationContext ：拿到 Spring 的容器
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// 拿到容器，需要什麼，就 get 什麼
		UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
		userServiceImpl.getUser();
	}
	
	/*
	@Test
	public void test(){
		// 用戶調的是 service 層，dao層的實現類不需要接觸
	   UserService service = new UserServiceImpl();
	   
	   ((UserServiceImpl) service).setUserDao( new UserDaoMySqlImpl() );
	   service.getUser();
	   //那我們現在又想用Oracle去實現呢
	   ((UserServiceImpl) service).setUserDao( new UserDaoOracleImpl() );
	   service.getUser();
	}
	*/
}
