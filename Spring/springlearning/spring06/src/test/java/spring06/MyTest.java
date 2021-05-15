package spring06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.config.MyConfig;
import com.wong.pojo.Dog;
import com.wong.pojo.User;

public class MyTest {
	@Test
	public void test1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	    User user = (User) applicationContext.getBean("user");
	    System.out.println(user.name);
	}
	
	@Test
	public void test2() {
		// 如果完全使用配置類的方式去做，我們就只能通過 AnnotationConfig 上下文來獲取容器，通過配置類的class對象加載
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		Dog dog = (Dog) applicationContext.getBean("dog");
		User user = (User) applicationContext.getBean("user");
		System.out.println(dog.name);
		System.out.println(user.name);
	}
}
