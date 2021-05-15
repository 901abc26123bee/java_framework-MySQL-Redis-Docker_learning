package com.wong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wong.pojo.Person;

@SpringBootTest
class DemoApplicationTests {

//    @Autowired //將狗狗自動注入進來
//    Dog dog;
	@Autowired
    Person person; //將person自動注入進來
    
    @Test
    public void contextLoads() {
        System.out.println(person); //打印看下狗狗對象
    }

}
