package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	List<Answer> findAll();
	
	Answer findById(long id);
	
	void deleteById(long id);
	
	void update(Answer answer);
	
	void insert(Answer answer);

}
