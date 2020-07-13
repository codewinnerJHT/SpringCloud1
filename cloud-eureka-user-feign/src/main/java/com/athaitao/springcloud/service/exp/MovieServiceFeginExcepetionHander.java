package com.athaitao.springcloud.service.exp;

import org.springframework.stereotype.Component;

import com.athaitao.springcloud.bean.Movie;
import com.athaitao.springcloud.service.MovieServiceFeign;
@Component
public class MovieServiceFeginExcepetionHander implements MovieServiceFeign {

	@Override
	public Movie getMovieById(Integer id) {
		Movie  movie=new Movie();
		movie.setId(-1);
		movie.setName("无此电影");
		return movie;
	}

}
