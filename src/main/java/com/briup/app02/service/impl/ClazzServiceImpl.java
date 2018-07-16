package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Clazz;
import com.briup.app02.dao.ClazzMapper;
import com.briup.app02.service.IClazzService;
@Service

public class ClazzServiceImpl implements IClazzService {
	@Autowired
	private ClazzMapper clazzMapper;

	@Override
	public List<Clazz> findAll() throws Exception {
		List<Clazz> list = clazzMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Clazz findById(long id) throws Exception {
		Clazz clazz = clazzMapper.findById(id);
		if(clazz != null){
			clazzMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return clazz;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Clazz clazz = clazzMapper.findById(id);
		if(clazz != null){
			clazzMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Clazz clazz) throws Exception {
		Clazz clazz1 = clazzMapper.findById(clazz.getId());
		if(clazz1 !=null){
			clazzMapper.update(clazz);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Clazz clazz) throws Exception {
		clazzMapper.insert(clazz);
	}
	
}

