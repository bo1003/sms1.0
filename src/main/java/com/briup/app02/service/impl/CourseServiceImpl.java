package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;
@Service

public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> findAll() throws Exception {
		List<Course> list = courseMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Course findById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course != null){
			courseMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return course;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Course course = courseMapper.findById(id);
		if(course != null){
			courseMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Course course) throws Exception {
		Course course1 = courseMapper.findById(course.getId());
		if(course1 !=null){
			courseMapper.update(course);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Course course) throws Exception {
		courseMapper.insert(course);
	}
	
}
