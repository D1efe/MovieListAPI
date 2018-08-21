package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Movie;
import com.qa.Domain.MovieInfo;
import com.qa.constants.Constants;

@Service
public class MovieService {

	@Autowired
	private Movie movie;

	@Autowired
	private Constants constant;

	private void setUp(String url) {
		RestTemplate rest = new RestTemplate();
		movie = rest.getForObject(url, Movie.class);
	}

	public Movie currentMovies() {
		setUp(constant.CURRENT_MOVIE);
		return movie;
	}

	public Movie upcomingMovies() {
		setUp(constant.UPCOMING_MOVIE);
		return movie;
	}

	public Movie findMovie(String search) {
		setUp(constant.SEARCH_MOVIE + search);
		return movie;
	}

	public String imageUrl(String movieName) {

		String movieUrl = "";
		setUp(constant.CURRENT_MOVIE);

		for (MovieInfo x : movie.getMovieDetails()) {
			if (x.getName().equalsIgnoreCase(movieName)) {
				movieUrl = constant.POSTER_IMAGE_URL + x.getImg();
			}
		}
		return movieUrl;
	}

}
