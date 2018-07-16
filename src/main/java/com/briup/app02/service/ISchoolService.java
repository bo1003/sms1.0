package com.briup.app02.service;

import java.util.List;

import com.briup.app02.bean.School;

public interface ISchoolService {
	//查询所有学校信息
	List<School> findAll() throws Exception;
	//通过id查找学校信息
	School findById(long id) throws Exception;
	//通过id删除学校信息
	void deleteById(long id) throws Exception;
	//更新学校信息
	void update(School school) throws Exception;
	//插入学校信息
	void insert(School school) throws Exception;

}
