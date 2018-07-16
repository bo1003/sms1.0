package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Answer;
import com.briup.app02.service.IAnswerService;
import com.briup.app02.util.MsgResponse;

//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private IAnswerService answerService;
	
	@GetMapping("findAllAnswer")
	public MsgResponse findAllAnswer(){
		try {
			List<Answer> list = answerService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdAnswer")
	public MsgResponse findByIdAnswer(long id){
		try {
			Answer answer = answerService.findById(id);
			return MsgResponse.success("查询成功！", answer);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdAnswer")
	public MsgResponse deleteByIdAnswer(long id){
		try {
			answerService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateAnswer")
	public MsgResponse updateAnswer(Answer answer){
		try {
			answerService.update(answer);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertAnswer")
	public MsgResponse insertAnswer(Answer answer){
		try {
			answerService.insert(answer);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

