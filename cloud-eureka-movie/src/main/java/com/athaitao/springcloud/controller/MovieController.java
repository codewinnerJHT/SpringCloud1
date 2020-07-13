package com.athaitao.springcloud.controller;

import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.athaitao.springcloud.bean.Movie;
import com.athaitao.springcloud.service.MovieService;


@RestController//组合注解相当于//@Controller+//@ResponseBody
//@Controller
public class MovieController {
	
	@Autowired
	MovieService movieService ;
	
	@Value("${server.port}")
	int port;
	//@ResponseBody
	@GetMapping("/getMovieById/{id}")
	public Movie getMovieById(@PathVariable("id") Integer id) {
		
		System.out.println("port="+port);
		return movieService.getMovieById(id);
	}
	
}
