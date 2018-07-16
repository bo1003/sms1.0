package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.School;
import com.briup.app02.service.ISchoolService;
import com.briup.app02.util.MsgResponse;

//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/school")

public class SchoolController {
	
	//注入studentSerivce的实例
		@Autowired
		private ISchoolService schoolSerivce;
		
		/**
		 * http://127.0.0.1:8080/school/findAllSchool
		 * 查询所有学校信息
		 */
		//映射
		@GetMapping("findAllSchool")
		public MsgResponse findAllSchool(){
			
			try {
				List<School> list = schoolSerivce.findAll();
				return MsgResponse.success("查询成功！", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		@GetMapping("findByIdSchool")
		public MsgResponse findByIdSchool(long id){
			try {
				School school = schoolSerivce.findById(id);
				return MsgResponse.success("查询成功！", school);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@GetMapping("deleteByIdSchool")
		public MsgResponse deleteByIdSchool(long id){
			try {
				schoolSerivce.deleteById(id);
				return MsgResponse.success("删除成功！", null);
				
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@PostMapping("updateSchool")
		public MsgResponse updateSchool(School school){
			try {
				schoolSerivce.update(school);
				return MsgResponse.success("更新成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		@PostMapping("insertSchool")
		public MsgResponse insertSchool(School school){
			try {
				schoolSerivce.insert(school);
				return MsgResponse.success("插入成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}

}
