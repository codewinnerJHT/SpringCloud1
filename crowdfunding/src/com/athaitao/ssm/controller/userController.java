package com.athaitao.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.athaitao.ssm.bean.Project;
import com.athaitao.ssm.bean.User;
import com.athaitao.ssm.service.userService;
import com.athaitao.ssm.service.projectService;;

@Controller
public class userController {
	
	@Autowired
	private userService userService;
	
	@ResponseBody
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8")
	public String login(String username,String userpswd) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String username1=new String(username.getBytes("iso-8859-1"),"utf-8");
			String userpswd1=new String(userpswd.getBytes("iso-8859-1"),"utf-8");
			List<User> users=userService.login(username1,userpswd1);
			map.put("code", "200");
			map.put("msg", "请求成功");
			map.put("user", users);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/register",produces="text/html;charset=utf-8")
	public String register(String loginacct,String username,String userpswd) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String loginacct1=new String(loginacct.getBytes("iso-8859-1"),"utf-8");
			String username1=new String(username.getBytes("iso-8859-1"),"utf-8");
			String userpswd1=new String(userpswd.getBytes("iso-8859-1"),"utf-8");
			userService.register(loginacct1,loginacct1,userpswd1);
			map.put("code", "200");
			map.put("msg", "请求成功");
			map.put("num", 1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/updatepswd",produces="text/html;charset=utf-8")
	public String updatepswd(String newloginacct,String newpassword) {
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String newloginacct1=new String(newloginacct.getBytes("iso-8859-1"),"utf-8");
			String newpassword1=new String(newpassword.getBytes("iso-8859-1"),"utf-8");
			Integer i=userService.updatepswd(newloginacct1,newpassword1);
			map.put("code", "200");
			map.put("msg", "请求成功");
			map.put("num", "1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();
	}
}
