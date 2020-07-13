package com.athaitao.ssm.service.ipml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athaitao.ssm.bean.News;
import com.athaitao.ssm.mapper.newsMapper;
import com.athaitao.ssm.service.newsService;
@Service
public class newsServiceImpl implements newsService{
	
	@Autowired
	private newsMapper newsmapper;
	
	@Override
	public List<News> selectnews(String type) {
		
		return newsmapper.selectnews(type);
	}

}
