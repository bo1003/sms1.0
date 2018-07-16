package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Question;

public interface QuestionMapper {
	List<Question> findAll();
	
	Question findById(long id);
	
	void deleteById(long id);
	
	void update(Question question);
	
	void insert(Question question);

}

