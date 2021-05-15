package com.wong.reflection;

public class Test6 {
	public static void main(String[] args) {
        A a = new A();
        System.out.println(a);//100
        /*
        1.加载到内存，产生一个类对应Class对象
        2.链接，链接结束后m=◎
        3.初始化
        <clinit>(){
            System. out . println( "A类静态代码块初始化") ;
            m = 300;
            m=100;
         }
         m=100
         */
        }
}

class A {
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;
    public A() {
        System.out.println("A类的参构造初始化");
    }
}
