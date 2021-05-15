package com.wong.reflection;

/*
 * static Class forName(String name) 	返回指定类名name对应的Class对象
Object newInstance() 	调用缺省构造函数，返回Class对象的一个实例
String getName() 	返回此Class对象所表示的实体（类、接口、数组类或者void）的名称
Class getSuperClass 	返回当前Class对象的父类Class对象
Class[] getinterfaces() 	获取当前Class对象的接口
ClassLoader getClassLoader() 	返回该类的加载器
Constructor[] getConstructors() 	返回一个包含某些Constructor对象的数组
Method getMothed(String name,Class… T) 	返回一个Method对象，此对象形参类型为param Type
Fied[] getDeclaredFields() 	返回Field对象的一个数组
*/
public class Test4 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person s1 = new Student();
        System.out.println("这个人是"+s1.name);
        //方式一：通过对象获取
        Class<?> c1 = s1.getClass();
        System.out.println(c1.hashCode());
        //方式二：通过forname获取
        Class<?> c2 = Class.forName("com.wong.reflection.Student");
        System.out.println(c2.hashCode());
        //通过类名.class获得
        Class<?> c3 = Student.class;
        System.out.println(c3.hashCode());
        //方式四：基本内置类型的包装类都有一个TYPE属性
        Class<?> c4 = Integer.TYPE;
        System.out.println(c4);
        //获得父类类型
        Class<?>  c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}
class Person{
    public String name;
    public Person(){}
    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Student extends Person{
    public Student(){
        this.name = "Student";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "Teacher";
    }
}

