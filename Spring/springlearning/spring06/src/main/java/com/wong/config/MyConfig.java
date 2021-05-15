package com.wong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.wong.pojo.Dog;

@Configuration // 代表這是一個配置類，就像之前的 beans.xml
//也會將這個類標註為Spring的一個組件，放到容器中（交給Spring託管），因為他本身就是一個 @Component （點開源碼）
@ComponentScan("com.wong.pojo")
@Import(MyConfig2.class) //導入合併其他配置類，類似於配置文件中的 inculde 標籤
public class MyConfig {

	@Bean 
	  // 通過方法註冊一個 bean，相當於之前寫的一個 bean 標籤
	  // 這個方法名 就是bean標籤中的id屬性
	  // 這個方法的返回值 就是bean標籤中的類型(class屬性)
	   public Dog dog(){
	       return new Dog(); //這就是返回要注入到bean的對象
	  }
}
