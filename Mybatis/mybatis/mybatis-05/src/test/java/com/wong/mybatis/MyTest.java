package com.wong.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.dao.StudentMapper;
import com.wong.mybatis.dao.TeacherMapper;
import com.wong.mybatis.pojo.Student;
import com.wong.mybatis.pojo.Teacher;
import com.wong.mybatis.utils.MybatisUtils;

public class MyTest {
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtils.getSession();
		TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
		Teacher teacher = mapper.getTeacher(1);
		System.out.println(teacher);
		sqlSession.close();
	}
	
	@Test
	public void testStudent() {
		SqlSession sqlSession = MybatisUtils.getSession();
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = mapper.getStudents();
		for(Student student : studentList) {
			System.out.println(student);
		}
 		sqlSession.close();
	}
}
