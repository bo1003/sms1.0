package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Student;
import com.briup.app02.service.IStudentService;
import com.briup.app02.util.MsgResponse;

//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/student")
public class StudentController {
	//注入studentSerivce的实例
	@Autowired
	private IStudentService studentSerivce;
	
	/**
	 * http://127.0.0.1:8080/student/findAllStudent
	 * 查询所有学生信息
	 */
	//映射
	@GetMapping("findAllStudent")
	public MsgResponse findAllStudent(){
		
		try {
			List<Student> list = studentSerivce.findAll();
			return MsgResponse.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * http://127.0.0.1:8080/student/findStudentById?id=3
	 * 通过id查询学生信息
	 */
	@GetMapping("findStudentById")
	public MsgResponse findStudentById(long id){
		try {
			Student student = studentSerivce.findById(id);
			return MsgResponse.success("查询成功！", student);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/**
	 * 
	 * 通过id删除学生信息
	 */
	@GetMapping("deleteStudentById")
	public MsgResponse deleteStudentById(long id){
		try {
			//调用service层代码删除学生信息
			studentSerivce.deleteById(id);
			//如果删除成功返回成功消息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			//先打印错误信息，让后台开发者知道问题所在
			e.printStackTrace();
			//返回错误信息，让前端开发者知道问题所在
			return MsgResponse.error(e.getMessage());
		}
		
	}
	/**
	 * 
	 * 更新学生信息
	 */
	@GetMapping("updateStudent")
	public MsgResponse updateStudent(Student student){
		try {
			studentSerivce.update(student);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	/**
	 * 
	 * 插入学生信息	
	 */
	@GetMapping("insertStudent")
	public MsgResponse insertStudent(Student student){
		try {
			studentSerivce.insert(student);
			return MsgResponse.success("插入成功！", null);	
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
