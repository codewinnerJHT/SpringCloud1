package com.athaitao.ssm.service;

import java.util.List;

import com.athaitao.ssm.bean.News;

public interface newsService{

	List<News> selectnews(String type);

}
