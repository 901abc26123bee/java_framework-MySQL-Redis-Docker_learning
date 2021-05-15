package com.wong.JUC.stream;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选:
 * 1、ID 必须是偶数
 * 2、年龄b必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 */
public class Test {
	public static void main(String[] args) {
		User u1 = new User(1,"a",21);
        User u2 = new User(2,"b",22);
        User u3 = new User(3,"c",23);
        User u4 = new User(4,"d",24);
        User u5 = new User(6,"e",25);
        //集合就是存储
        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
        //计算交给Stream流
        list.stream()
	        .filter(u-> u.getId()%2==0)  //断定型 一个参数，返回值布尔
	        .filter(u-> u.getAge()>23)   //断定型 一个参数，返回值布尔
	        .map(u-> u.getName().toUpperCase()) //函数式 一个参数，泛型key参数，返回类型泛型value)
        	.sorted((uu1, uu2)->{return uu1.compareTo(uu2);})
        	.limit(1)
        	.forEach(System.out::println);
	}
}
//用户
@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
  private int id;
  private String name;
  private int age;
}