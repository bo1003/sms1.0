package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;
@Service

public   class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;

	//调用studentMapper查询所有学生信息
	@Override
	public List<Student> findAll() throws Exception {
		List<Student> list = studentMapper.findAll();
		return list;
	}

    //调用studentMapper通过id查询学生信息
	@Override
	public Student findById(long id) throws Exception {
		//通过id查找
		Student student = studentMapper.findById(id);
		//如果该学生存在，执行查询操作，如果该学生不存在，抛出异常
		if(student != null){
			studentMapper.findById(id);
		}
		else{
			throw new Exception("该学生不存在！查询异常！");
		}
		return student;
	}

	//调用studentMapper通过id删除学生信息
	@Override
	public void deleteById(long id) throws Exception {
		//通过id查找
		Student student = studentMapper.findById(id);
		//如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(student != null){
			studentMapper.deleteById(id);
		}
		else{
			throw new Exception("该学生不存在！删除异常！");
		}
	}

	//调用studengMapper更新学生信息
	@Override
	public void update(Student student) throws Exception {
		Student student1 = studentMapper.findById(student.getId());
		if(student1 != null){
			studentMapper.update(student);
		}
		else{
			throw new Exception("该学生不存在！更新异常！");
		}
		
	}

	//调用studengMapper插入学生信息
	@Override
	public void insert(Student student) throws Exception {
		Student student1 = studentMapper.findById(student.getId());
		if(student1 == null){
			studentMapper.insert(student);
		}
		else{
			throw new Exception("该学生已存在！插入异常！");
		}
		
	}


	

}
