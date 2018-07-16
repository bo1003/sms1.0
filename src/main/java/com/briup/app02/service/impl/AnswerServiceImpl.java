package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Answer;
import com.briup.app02.dao.AnswerMapper;
import com.briup.app02.service.IAnswerService;
@Service

public class AnswerServiceImpl implements IAnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> findAll() throws Exception {
		List<Answer> list = answerMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Answer findById(long id) throws Exception {
		Answer answer = answerMapper.findById(id);
		if(answer != null){
			answerMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return answer;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Answer answer = answerMapper.findById(id);
		if(answer != null){
			answerMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Answer answer) throws Exception {
		Answer answer1 = answerMapper.findById(answer.getId());
		if(answer1 !=null){
			answerMapper.update(answer);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Answer answer) throws Exception {
		answerMapper.insert(answer);
	}
	
}

