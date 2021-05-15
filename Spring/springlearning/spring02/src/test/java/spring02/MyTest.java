package spring02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.pojo.Hello;

public class MyTest {
	@Test
	public void test(){
		// 要加載 xml文件，必須通過 ApplicationContext（固定寫法）---> 獲取 Spriing 的上下文對象
	   // 解析beans.xml文件 , 生成管理相應的Bean對象
	   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	// 我們的對象都在 Spring 中管理了，要使用直接從裡面取出來
	   // getBean : 參數即為spring配置文件中bean的id .
	   Hello hello = (Hello) context.getBean("hello");
	   hello.show();
	}
}
