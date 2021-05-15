package spring07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.service.UserService;

public class MyTest {
	@Test
	   public void test(){
	       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	       // 動態代理代理的是接口
	       UserService userService = (UserService) context.getBean("userService");
	       userService.search();
	  }
}
