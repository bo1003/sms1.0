package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="课程相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("findAllCourse")
	public MsgResponse findAllCourse(){
		try {
			List<Course> list = courseService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdCourse")
	public MsgResponse findByIdCourse(long id){
		try {
			Course course = courseService.findById(id);
			return MsgResponse.success("查询成功！", course);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdCourse")
	public MsgResponse deleteByIdCourse(long id){
		try {
			courseService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateCourse")
	public MsgResponse updateCourse(Course course){
		try {
			courseService.update(course);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertCourse")
	public MsgResponse insertCourse(Course course){
		try {
			courseService.insert(course);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

