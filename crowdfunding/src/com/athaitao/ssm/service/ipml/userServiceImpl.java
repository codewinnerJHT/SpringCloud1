package com.athaitao.ssm.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athaitao.ssm.bean.User;
import com.athaitao.ssm.mapper.UserMapper;
import com.athaitao.ssm.service.userService;

@Service
public class userServiceImpl implements userService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> login(String username, String userpswd) {
		return userMapper.login(username, userpswd);
	}

	@Override
	public void register(String loginacct, String username, String userpswd) {
		// TODO Auto-generated method stub
		userMapper.register(loginacct,username,userpswd);
	}

	@Override
	public Integer updatepswd(String newloginacct, String newpassword) {
		
		return userMapper.updatepswd(newloginacct,newpassword);
	}
	}
