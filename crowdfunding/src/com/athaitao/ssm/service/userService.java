package com.athaitao.ssm.service;

import java.util.List;

import com.athaitao.ssm.bean.User;

public interface userService {

	List<User> login(String username, String userpswd);

	void register(String loginacct, String username, String userpswd);

	Integer updatepswd(String newloginacct, String newpassword);

}
