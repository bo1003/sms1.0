package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Course;

public interface ICourseService {
	//查询所有课程信息
	List<Course> findAll() throws Exception;

}
