package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Student;

public interface IStudentService {
	//查询所有学生信息
	List<Student> findAll() throws Exception;
	//通过id查询学生信息
	Student findById(long id) throws Exception;
	//通过id删除学生信息
	void deleteById(long id) throws Exception;
	//更新学生信息
	void update(Student student) throws Exception;
	//插入学生信息
	void insert(Student student) throws Exception;
	
	//作用：保证代码能正常运行
}
