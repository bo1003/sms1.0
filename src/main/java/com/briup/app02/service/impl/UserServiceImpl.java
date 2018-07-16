package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.service.IUserService;
@Service

public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() throws Exception {
		List<User> list = userMapper.findAll();
		if(!list.isEmpty()){
			return list;
		}
		else{
			throw new Exception("查询异常！");
		}
	}

	@Override
	public User findById(long id) throws Exception {
		User user = userMapper.findById(id);
		if(user != null){
			userMapper.findById(id);
		}
		else{
			throw new Exception("查询异常！");
		}
		return user;
	}

	@Override
	public void deleteById(long id) throws Exception {
		User user = userMapper.findById(id);
		if(user != null){
			userMapper.deleteById(id);
		}
		else{
			throw new Exception("删除异常！");
		}
	}

	@Override
	public void update(User user) throws Exception {
		User user1 = userMapper.findById(user.getId());
		if(user1 !=null){
			userMapper.update(user);
		}
		else{
			throw new Exception("更新异常！");
		}
	}

	@Override
	public void insert(User user) throws Exception {
		userMapper.insert(user);
	}
	
}
