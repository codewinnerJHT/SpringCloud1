package com.athaitao.springcloud.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.athaitao.springcloud.bean.Movie;
import com.athaitao.springcloud.bean.User;
import com.athaitao.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	@Autowired
	UserService userService;//本地接口
	
	@Autowired
	private RestTemplate restTemplate;//远程调用接口
	
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@HystrixCommand(fallbackMethod="buyMovieHystrix")
	@GetMapping("/buyMovie/{userId}/{MovieId}")
	public Map<String,Object> buyMovie(@PathVariable("userId") Integer userId,
										@PathVariable("MovieId") Integer MovieId){
		
		Map<String, Object> map=new HashMap<String,Object>();
		
		User user = userService.getUserById(userId);
		map.put("user", user);
		//用户服务 远程调用 电影服务：如何远程调用
		Movie movie= restTemplate.getForObject("http://CLOUD-PROVIDER-MOVIE/getMovieById/"+MovieId, Movie.class);
		map.put("movie", movie);
		return map;
	}
	
	public Map<String,Object> buyMovieHystrix(@PathVariable("userId") Integer userId,
			@PathVariable("MovieId") Integer MovieId){
		Map<String, Object> map=new HashMap<String,Object>();
		
		User user=new User();
		user.setId(-1);
		user.setName("无此用户");
		
		Movie movie=new Movie();
		movie.setId(-100);
		movie.setName("无此电影");
		map.put("user", user);
		map.put("movie", movie);
		return map;
	}
}
