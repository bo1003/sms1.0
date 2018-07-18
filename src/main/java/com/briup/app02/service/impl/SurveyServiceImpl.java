package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.dao.extend.SurveyVMMapper;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.vm.SurveyVM;
@Service

public class SurveyServiceImpl implements ISurveyService {
	@Autowired
	private SurveyMapper surveyMapper;
    @Autowired
    private SurveyVMMapper surveyVMMapper;
	
	@Override
	public List<SurveyVM> findAllSurveyVM() throws Exception {
		List<SurveyVM> list = surveyVMMapper.findAllSurveyVM();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public SurveyVM findByIdSurveyVM(long id) throws Exception {
		SurveyVM surveyVM = surveyVMMapper.findByIdSurveyVM(id);
		if(surveyVM != null){
			surveyVMMapper.findByIdSurveyVM(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return surveyVM;
	}
	
	@Override
	public List<Survey> findAll() throws Exception {
		List<Survey> list = surveyMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Survey findById(long id) throws Exception {
		Survey survey = surveyMapper.findById(id);
		if(survey != null){
			surveyMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return survey;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Survey survey = surveyMapper.findById(id);
		if(survey != null){
			surveyMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Survey survey) throws Exception {
		Survey survey1 = surveyMapper.findById(survey.getId());
		if(survey1 !=null){
			surveyMapper.update(survey);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Survey survey) throws Exception {
		surveyMapper.insert(survey);
	}
	
}
