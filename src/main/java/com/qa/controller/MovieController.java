package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.MovieService;

@RequestMapping("/movie")
@RestController
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping("/search-movie/{key}")
	@ResponseBody
	public String findMovie(@PathVariable String key) {
		return service.findMovie(key);		
	}
	
	@RequestMapping("/all-movies")
	@ResponseBody
	public String allMovies() {
		return service.allMovies();
	}

}
