package com.athaitao.springcloud.service;

import org.springframework.stereotype.Service;

import com.athaitao.springcloud.bean.User;


public interface UserService {

	User getUserById(Integer id);

}
