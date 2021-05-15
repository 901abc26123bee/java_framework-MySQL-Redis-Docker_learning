package com.wong.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wong.mybatis.dao.TeacherMapper;
import com.wong.mybatis.pojo.Teacher;
import com.wong.mybatis.utils.MybatisUtils;

public class MtTest {
	@Test
	public void getTeacher() {
		SqlSession session = MybatisUtils.getSession();
	    TeacherMapper mapper = session.getMapper(TeacherMapper.class);
	    Teacher teacher = mapper.getTeacher(1);
	    System.out.println(teacher);
	    /* output
	     * Teacher(id=0, name=atom, students=[Student(propertyid=1, name=小明, tid=1), Student(propertyid=2, name=小红, tid=1), Student(propertyid=3, name=小張, tid=1), Student(propertyid=4, name=小李, tid=1), Student(propertyid=5, name=小王, tid=1)])
	     * */
	    session.close();
	}
	
	@Test
	public void getTeacher2() {
		SqlSession session = MybatisUtils.getSession();
	    TeacherMapper mapper = session.getMapper(TeacherMapper.class);
	    Teacher teacher = mapper.getTeacher2(1);
	    System.out.println(teacher);
	    /* output
	     * Teacher(id=0, name=atom, students=[Student(propertyid=1, name=小明, tid=1), Student(propertyid=2, name=小红, tid=1), Student(propertyid=3, name=小張, tid=1), Student(propertyid=4, name=小李, tid=1), Student(propertyid=5, name=小王, tid=1)])
	     * */
	    session.close();
	}
}
