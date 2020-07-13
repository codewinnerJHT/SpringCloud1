package com.athaitao.springcloud.dao;

import org.springframework.stereotype.Repository;

import com.athaitao.springcloud.bean.Movie;

@Repository
public class MovieDao {

	public Movie getMovieById(Integer id) {
		Movie movie=new Movie();
		movie.setId(id);
		movie.setName("红海行动-"+id);
		return movie;
	}

}
