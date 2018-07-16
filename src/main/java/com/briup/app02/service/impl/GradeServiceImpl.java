package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Grade;
import com.briup.app02.dao.GradeMapper;
import com.briup.app02.service.IGradeService;
@Service

public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public List<Grade> findAll() throws Exception {
		List<Grade> list = gradeMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Grade findById(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if(grade != null){
			gradeMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return grade;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Grade grade = gradeMapper.findById(id);
		if(grade != null){
			gradeMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Grade grade) throws Exception {
		Grade grade1 = gradeMapper.findById(grade.getId());
		if(grade1 !=null){
			gradeMapper.update(grade);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Grade grade) throws Exception {
		gradeMapper.insert(grade);
	}
	
}
