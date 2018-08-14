package com.qa.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movie")
@RestController
public class MovieController {
	
	@RequestMapping("/search-movie/{key}")
	@ResponseBody
	public String findMovie(@PathVariable String key) {
		
		return "";
		
	}
	
	@RequestMapping("/all-movies")
	@ResponseBody
	public String allMovies() {
		
		return "";
		
	}

}
