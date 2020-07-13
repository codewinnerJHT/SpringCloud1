package com.athaitao.springcloud.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athaitao.springcloud.bean.User;
import com.athaitao.springcloud.dao.UserDao;
import com.athaitao.springcloud.service.UserService;

@Service
public class UserServicerImpl implements UserService {
	@Autowired
	UserDao usedao;
	
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return usedao.getUserById(id);
	}

}
