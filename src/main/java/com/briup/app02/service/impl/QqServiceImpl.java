package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Qq;
import com.briup.app02.dao.QqMapper;
import com.briup.app02.dao.extend.QqVMMapper;
import com.briup.app02.service.IQqService;
import com.briup.app02.vm.QqVM;
@Service

public class QqServiceImpl implements IQqService {
	@Autowired
	private QqMapper qqMapper;
	@Autowired
	private QqVMMapper qqVMMapper;
	
	@Override
	public List<QqVM> findAllQqVM() throws Exception {
		List<QqVM> list = qqVMMapper.findAllQqVM();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}
	
	@Override
	public QqVM findByIdQqVM(long id) throws Exception {
		QqVM qqVM = qqVMMapper.findByIdQqVM(id);
		if(qqVM != null){
			qqVMMapper.findByIdQqVM(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return qqVM;
	}

	@Override
	public List<Qq> findAll() throws Exception {
		List<Qq> list = qqMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public Qq findById(long id) throws Exception {
		Qq qq = qqMapper.findById(id);
		if(qq != null){
			qqMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return qq;
	}

	@Override
	public void deleteById(long id) throws Exception {
		Qq qq = qqMapper.findById(id);
		if(qq != null){
			qqMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(Qq qq) throws Exception {
		Qq qq1 = qqMapper.findById(qq.getId());
		if(qq1 !=null){
			qqMapper.update(qq);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(Qq qq) throws Exception {
		qqMapper.insert(qq);
	}
	
}

