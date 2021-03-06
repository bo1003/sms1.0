package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.Survey;
import com.briup.app02.vm.SurveyVM;

public interface ISurveyService {
	List<SurveyVM> findAllSurveyVM() throws Exception;
	
	SurveyVM findByIdSurveyVM(long id) throws Exception;
	
	List<Survey> findAll() throws Exception;
	
	Survey findById(long id) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void update(Survey survey) throws Exception;
	
	void insert(Survey survey) throws Exception;

}

