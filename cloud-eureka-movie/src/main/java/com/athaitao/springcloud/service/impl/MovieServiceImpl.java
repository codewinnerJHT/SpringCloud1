package com.athaitao.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athaitao.springcloud.bean.Movie;
import com.athaitao.springcloud.dao.MovieDao;
import com.athaitao.springcloud.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieDao moiveDao;
	
	@Override
	public Movie getMovieById(Integer id) {
		
		return moiveDao.getMovieById(id);
	}

}
