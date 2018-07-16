package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.School;

public interface SchoolMapper {
	
	//查询所有学校信息
	List<School> findAll();
	//通过id查找学校信息
	School findById(long id);
	//通过id删除学校信息
	void deleteById(long id);
	//更新学校信息
	void update(School school);
	//插入学校信息
	void insert(School school);

}
