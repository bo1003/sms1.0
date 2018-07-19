package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.User;
import com.briup.app02.service.IUserService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="班主任相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		try {
			List<User> list = userService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdUser")
	public MsgResponse findByIdUser(long id){
		try {
			User user = userService.findById(id);
			return MsgResponse.success("查询成功！", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdUser")
	public MsgResponse deleteByIdUser(long id){
		try {
			userService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateUser")
	public MsgResponse updateUser(User user){
		try {
			userService.update(user);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertUser")
	public MsgResponse insertUser(User user){
		try {
			userService.insert(user);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

