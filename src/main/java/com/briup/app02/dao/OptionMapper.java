package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Option;

public interface OptionMapper {
	List<Option> findByQuestionId(long id);
	
	List<Option> findAll();
	
	Option findById(long id);
	
	void deleteById(long id);
	
	void update(Option option);
	
	void insert(Option option);

}
