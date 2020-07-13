package com.athaitao.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.athaitao.ssm.bean.News;
import com.athaitao.ssm.service.newsService;

@Controller
public class NewsController {
	@Autowired
	private newsService newsService;
	@ResponseBody
	@RequestMapping(value="/news",produces="text/html;charset=utf-8")
	public String selectnews(String type) {
		List<News> news=newsService.selectnews(type);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("msg", "请求成功");
		map.put("news", news);
		return JSON.toJSONString(map).toString();
	}
}
