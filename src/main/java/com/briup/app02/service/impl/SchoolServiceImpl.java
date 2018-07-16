package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;
import com.briup.app02.service.ISchoolService;
@Service

public class SchoolServiceImpl implements ISchoolService {
	@Autowired
	private SchoolMapper schoolMapper;
	//通过schoolMapper查询所有学校信息
	@Override
	public List<School> findAll() throws Exception{
		List<School> list = schoolMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
		
	}
	@Override
	public School findById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if(school !=null){
			schoolMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return school;
	}
	@Override
	public void deleteById(long id) throws Exception {
		School school = schoolMapper.findById(id);
		if(school !=null){
			schoolMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}
	@Override
	public void update(School school) throws Exception {
		School school1 = schoolMapper.findById(school.getId());
		if(school1 != null){
			schoolMapper.update(school);
		}
		else{
			throw new Exception("更新异常！");
		}
		
	}
	@Override
	public void insert(School school) throws Exception {
		schoolMapper.insert(school);
	}
}
