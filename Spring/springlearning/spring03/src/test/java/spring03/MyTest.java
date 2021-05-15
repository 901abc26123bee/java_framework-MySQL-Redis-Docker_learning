package spring03;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.pojo.User;

public class MyTest {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	   //在執行getBean的時候, user已經創建好了 , 通過無參構造
	   User user = (User) context.getBean("user-alis");
	   User user2 = (User) context.getBean("user");
	   User user3 = (User) context.getBean("n1");
	   User user4 = (User) context.getBean("nn");
	   
	   System.out.println(user == user2);
	   System.out.println(user3 == user2);
	   System.out.println(user4 == user2);
	   //調用對象的方法 .
	   user.show();
	}
}
