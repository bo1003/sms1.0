package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QqVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题-问卷相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/qq")
public class QqController {
	@Autowired
	private IQqService qqService;
	
	@ApiOperation(value="查询所有问题-问卷信息",notes="能联级查询到问题和问卷的相关信息")
	@GetMapping("findAllQqVM")
	public MsgResponse findAllQqVM(){
		try {
			List<QqVM> list = qqService.findAllQqVM();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询问题-问卷信息",notes="能联级查询到问题和问卷的相关信息")
	@GetMapping("findByIdQqVM")
	public MsgResponse findByIdQqVM(long id){
		try {
			QqVM qqVM = qqService.findByIdQqVM(id);
			return MsgResponse.success("查询成功！", qqVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findAllQq")
	public MsgResponse findAllQq(){
		try {
			List<Qq> list = qqService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdQq")
	public MsgResponse findByIdQq(long id){
		try {
			Qq qq = qqService.findById(id);
			return MsgResponse.success("查询成功！", qq);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdQq")
	public MsgResponse deleteByIdQq(long id){
		try {
			qqService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateQq")
	public MsgResponse updateQq(Qq qq){
		try {
			qqService.update(qq);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertQq")
	public MsgResponse insertQq(Qq qq){
		try {
			qqService.insert(qq);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

