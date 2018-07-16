package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Question;
import com.briup.app02.dao.QuestionMapper;
import com.briup.app02.service.IQuestionService;
@Service

public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<Question> findAll() throws Exception {
		List<Question> list = questionMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Question findById(long id) throws Exception {
		Question question = questionMapper.findById(id);
		if(question != null){
			questionMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return question;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Question question = questionMapper.findById(id);
		if(question != null){
			questionMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Question question) throws Exception {
		Question question1 = questionMapper.findById(question.getId());
		if(question1 !=null){
			questionMapper.update(question);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Question question) throws Exception {
		questionMapper.insert(question);
	}
	
}

