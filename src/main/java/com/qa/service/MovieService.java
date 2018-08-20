package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Movie;
import com.qa.constants.Constants;
import com.qa.utility.JSONUtility;

@Service
public class MovieService {

	@Autowired
	private Movie movie;
	private JSONUtility util;

	private Constants constant;

	private void setUp(String url) {
		RestTemplate rest = new RestTemplate();
		movie = rest.getForObject(url, Movie.class);
	}

	public String currentMovies() {
		setUp(constant.CURRENT_MOVIE);
		return util.getJSONForObject(movie);
	}

	public String upcomingMovies() {
		setUp(constant.UPCOMING_MOVIE);
		return util.getJSONForObject(movie);
	}

	public String findMovie(String search) {
		setUp(constant.SEARCH_MOVIE + search);
		return util.getJSONForObject(movie);
	}

}
