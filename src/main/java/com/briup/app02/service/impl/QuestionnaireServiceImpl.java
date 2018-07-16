package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.dao.QuestionnaireMapper;
import com.briup.app02.service.IQuestionnaireService;
@Service

public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;

	@Override
	public List<Questionnaire> findAll() throws Exception {
		List<Questionnaire> list = questionnaireMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Questionnaire findById(long id) throws Exception {
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if(questionnaire != null){
			questionnaireMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return questionnaire;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Questionnaire questionnaire = questionnaireMapper.findById(id);
		if(questionnaire != null){
			questionnaireMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Questionnaire questionnaire) throws Exception {
		Questionnaire questionnaire1 = questionnaireMapper.findById(questionnaire.getId());
		if(questionnaire1 !=null){
			questionnaireMapper.update(questionnaire);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Questionnaire questionnaire) throws Exception {
		questionnaireMapper.insert(questionnaire);
	}
	
}

