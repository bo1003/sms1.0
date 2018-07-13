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

	//通过调用CourseMapper查询所有课程信息
	@Override
	public List<Course> findAll() throws Exception {
		List<Course> list = courseMapper.findAll();
		return list;
	}

}
