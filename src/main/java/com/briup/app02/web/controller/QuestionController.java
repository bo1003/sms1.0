package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.QuestionVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description  = "问题相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@GetMapping("findAllQuestion")
	public MsgResponse findAllQuestion(){
		try {
			List<Question> list = questionService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有问题信息",notes="能查询到问题的选项")
	@GetMapping("findAllQuestionVM")
	public MsgResponse findAllQuestionVM(){
		try {
			List<QuestionVM> list = questionService.findAllQuestionVM();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询问题信息",notes="能查询到问题的选项")
	@GetMapping("findByIdQuestionVM")
	public MsgResponse findByIdQuestionVM(long id){
		try {
			QuestionVM questionVM = questionService.findByIdQuestionVM(id);
			return MsgResponse.success("查询成功！", questionVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存问题信息",notes="保存问题时同时还保存选项")
	@PostMapping("saveQuestion")
	public MsgResponse saveQuestion(QuestionVM questionVM){
		try {
			questionService.saveQuestion(questionVM);
			return MsgResponse.success("保存成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdQuestion")
	public MsgResponse findByIdQuestion(long id){
		try {
			Question question = questionService.findById(id);
			return MsgResponse.success("查询成功！", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdQuestion")
	public MsgResponse deleteByIdQuestion(long id){
		try {
			questionService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateQuestion")
	public MsgResponse updateQuestion(Question question){
		try {
			questionService.update(question);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertQuestion")
	public MsgResponse insertQuestion(Question question){
		try {
			questionService.insert(question);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

