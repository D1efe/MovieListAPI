package com.qa.service;

import com.qa.constants.Constants;
import com.qa.utility.JSONUtility;

public class MovieService {
	
	JSONUtility util = new JSONUtility();
	Constants constant = new Constants();
	
	public String allMovies() {
		
		return null;
		
	}
	
	public String findMovie(String key) {
		
		String url = constant.MOVIE_SEARCH_URL + key;

		return key;
		
	}
	

}
