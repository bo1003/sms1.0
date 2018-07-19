package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Option;
import com.briup.app02.service.IOptionService;
import com.briup.app02.util.MsgResponse;

import io.swagger.annotations.Api;

@Api(description="选项相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/option")
public class OptionController {
	@Autowired
	private IOptionService optionService;
	
	@GetMapping("findAllOption")
	public MsgResponse findAllOption(){
		try {
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdOption")
	public MsgResponse findByIdOption(long id){
		try {
			Option option = optionService.findById(id);
			return MsgResponse.success("查询成功！", option);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdOption")
	public MsgResponse deleteByIdOption(long id){
		try {
			optionService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateOption")
	public MsgResponse updateOption(Option option){
		try {
			optionService.update(option);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertOption")
	public MsgResponse insertOption(Option option){
		try {
			optionService.insert(option);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

