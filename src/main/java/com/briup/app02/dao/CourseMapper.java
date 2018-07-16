package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	List<Course> findAll();
	
	Course findById(long id);
	
	void deleteById(long id);
	
	void update(Course course);
	
	void insert(Course course);

}

