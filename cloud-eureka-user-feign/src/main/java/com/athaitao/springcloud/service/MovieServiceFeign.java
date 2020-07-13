package com.athaitao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.athaitao.springcloud.bean.Movie;
import com.athaitao.springcloud.service.exp.MovieServiceFeginExcepetionHander;

@FeignClient(value="CLOUD-PROVIDER-MOVIE",fallback=MovieServiceFeginExcepetionHander.class)
public interface MovieServiceFeign {
	@GetMapping("/getMovieById/{id}")
	public Movie getMovieById(@PathVariable("id") Integer id);
	
}
