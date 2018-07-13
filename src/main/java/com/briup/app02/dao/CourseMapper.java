package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	//查询所有课程信息
	List<Course> findAll();

}
