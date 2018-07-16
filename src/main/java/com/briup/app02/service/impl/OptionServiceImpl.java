package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.service.IOptionService;
@Service

public class OptionServiceImpl implements IOptionService {
	@Autowired
	private OptionMapper optionMapper;

	@Override
	public List<Option> findAll() throws Exception {
		List<Option> list = optionMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Option findById(long id) throws Exception {
		Option option = optionMapper.findById(id);
		if(option != null){
			optionMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return option;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Option option = optionMapper.findById(id);
		if(option != null){
			optionMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Option option) throws Exception {
		Option option1 = optionMapper.findById(option.getId());
		if(option1 !=null){
			optionMapper.update(option);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Option option) throws Exception {
		optionMapper.insert(option);
	}
	
}

