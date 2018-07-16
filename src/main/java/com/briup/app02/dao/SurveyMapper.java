package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Survey;

public interface SurveyMapper {
	List<Survey> findAll();
	
	Survey findById(long id);
	
	void deleteById(long id);
	
	void update(Survey survey);
	
	void insert(Survey survey);

}
