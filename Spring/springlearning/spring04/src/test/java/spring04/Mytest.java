package spring04;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.pojo.Student;
import com.wong.pojo.User;

public class Mytest {
	@Test
	public void test01() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		 Student student = (Student) context.getBean("student");
		 System.out.println(student.getName());
		 student.show();
	}
	
	@Test
	public void test02() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
		 User user = context.getBean("userp", User.class); // second parameter free you from 類型強轉
		 System.out.println(user.toString());
	}
	
	@Test
	public void test03() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
		 User user = context.getBean("userc", User.class); // second parameter free you from 類型強轉
		 System.out.println(user.toString());
	}
	
	@Test
	public void test04() {
		 ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
		 User user1 = context.getBean("userc", User.class); // second parameter free you from 類型強轉
		 User user2 = context.getBean("userc", User.class);
		 System.out.println(user1==user2);
	}
	
	
}
