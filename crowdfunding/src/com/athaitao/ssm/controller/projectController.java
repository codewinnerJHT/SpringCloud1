package com.athaitao.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.athaitao.ssm.bean.Banner;
import com.athaitao.ssm.bean.Project;
import com.athaitao.ssm.bean.User;
import com.athaitao.ssm.service.projectService;

@Controller
public class projectController {
	
	@Autowired
	private projectService projectService;
	
	@ResponseBody
	@RequestMapping(value="/hot",produces="text/html;charset=utf-8")
	public String hot(String hotstatus) {
		List<Project> hot=projectService.selecthot(hotstatus);
		List<Banner> bannerurl= projectService.selectbanneruel();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("gethost", hot);
		map.put("bannerurl", bannerurl);
		return JSON.toJSONString(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/collect",produces="text/html;charset=utf-8")
	public String collect(String uid,String pid) {
		projectService.collect(uid,pid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("num", "1");
		return JSON.toJSONString(map).toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/follow",produces="text/html;charset=utf-8")
	public String follow(String uid,String pid,String price,String status) {
		projectService.follow(uid,pid,price,status);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("num", "1");
		return JSON.toJSONString(map).toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/selectcollect",produces="text/html;charset=utf-8")
	public String selectcollect(String uid) {
		List<Project> projects=projectService.selectcollect(uid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("projects", projects);
		return JSON.toJSONString(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/selectsearch",produces="text/html;charset=utf-8")
	public String selectsearch(String name) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String name1=new String(name.getBytes("iso-8859-1"),"utf-8");
			List<Project> projects=projectService.selectsearch(name1);
			map.put("code", "200");
			map.put("msg", "请求成功");
			map.put("projects", projects);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/add",produces="text/html;charset=utf-8")
	public String add(String name,String information,String money,String day,String briefintroduction) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		try {
			String name1=new String(name.getBytes("iso-8859-1"),"utf-8");
			String information1=new String(information.getBytes("iso-8859-1"),"utf-8");
			String money1=new String(money.getBytes("iso-8859-1"),"utf-8");
			String day1=new String(day.getBytes("iso-8859-1"),"utf-8");
			String briefintroduction1=new String(briefintroduction.getBytes("iso-8859-1"),"utf-8");
			projectService.add(name1,information1,money1,day1,briefintroduction1);
			map.put("code", "200");
			map.put("msg", "请求成功");
			map.put("num", "1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/delcollect",produces="text/html;charset=utf-8")
	public String delcollect(String pid,String uid) {
		projectService.delcollect(pid,uid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("num", "1");
		return JSON.toJSONString(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/selectCount",produces="text/html;charset=utf-8")
	public String selectCount(String uid) {
		Integer i= projectService.selectCount(uid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("num", i);
		return JSON.toJSONString(map).toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/Summoney",produces="text/html;charset=utf-8")
	public String Summoney(String uid) {
		Double i= projectService.Summoney(uid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("num", i);
		return JSON.toJSONString(map).toString();
	}
}
