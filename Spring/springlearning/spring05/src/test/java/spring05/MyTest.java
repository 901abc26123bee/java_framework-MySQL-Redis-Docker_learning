package spring05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wong.pojo.People;

public class MyTest {
   @Test
   public void testByNameByType() {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       People user = (People) context.getBean("user");
       user.getCat().shout();
       user.getDog().shout();
  }
   
   @Test
   public void testMethodAutowire() {
       ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       People user = (People) context.getBean("people");
       user.getCat().shout();
       user.getDog().shout();
  }
}
