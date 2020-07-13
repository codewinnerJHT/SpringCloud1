package com.athaitao.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athaitao.ssm.bean.User;

public interface UserMapper {
	//用户登录接口
	List<User> login(@Param("username")String username,@Param("userpswd")String userpswd);
	//用户注册接口
	void register(@Param("loginacct")String loginacct,@Param("username") String username, @Param("userpswd")String userpswd);
	//修改密码
	Integer updatepswd(@Param("newloginacct")String newloginacct,@Param("newpassword") String newpassword);
}
