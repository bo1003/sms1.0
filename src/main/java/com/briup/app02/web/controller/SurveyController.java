package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;
import com.briup.app02.vm.SurveyVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="调查相关接口")
//Rest服务构架
@RestController
//路由的命名空间
@RequestMapping("/survey")
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询所有调查信息",notes="能联级查询到问卷，班主任，班级和课程的相关信息")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try {
			List<SurveyVM> list = surveyService.findAllSurveyVM();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id查询调查信息",notes="能联级查询到问卷，班主任，班级和课程的相关信息")
	@GetMapping("findByIdSurveyVM")
	public MsgResponse findByIdSurveyVM(long id){
		try {
			SurveyVM surveyVM = surveyService.findByIdSurveyVM(id);
			return MsgResponse.success("查询成功！", surveyVM);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findAllSurvey")
	public MsgResponse findAllSurvey(){
		try {
			List<Survey> list = surveyService.findAll();
			return MsgResponse.success("查询成功!", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("findByIdSurvey")
	public MsgResponse findByIdSurvey(long id){
		try {
			Survey survey = surveyService.findById(id);
			return MsgResponse.success("查询成功！", survey);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteByIdSurvey")
	public MsgResponse deleteByIdSurvey(long id){
		try {
			surveyService.deleteById(id);
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("updateSurvey")
	public MsgResponse updateSurvey(Survey survey){
		try {
			surveyService.update(survey);
			return MsgResponse.success("更新成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@PostMapping("insertSurvey")
	public MsgResponse insertSurvey(Survey survey){
		try {
			surveyService.insert(survey);
			return MsgResponse.success("插入成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}

