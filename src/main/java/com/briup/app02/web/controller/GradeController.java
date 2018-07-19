package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="年及相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdGrade")
	public MsgResponse findByIdGrade(long id){
		try {
			Grade grade = gradeService.findById(id);
			return MsgResponse.success("查询成功！", grade);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdGrade")
	public MsgResponse deleteByIdGrade(long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateGrade")
	public MsgResponse updateGrade(Grade grade){
		try {
			gradeService.update(grade);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertGrade")
	public MsgResponse insertGrade(Grade grade){
		try {
			gradeService.insert(grade);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
