package com.athaitao.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.athaitao.ssm.bean.News;

public interface newsMapper {
	//查询新闻
	List<News> selectnews(@Param("type")String type);

}
