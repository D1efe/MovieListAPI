package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
	private MovieInfo mInfo;

	@Autowired
	private Constants constant;

	private void setUp(String url) {
		RestTemplate rest = new RestTemplate();
		movie = rest.getForObject(url, Movie.class);

		// for(MovieInfo x : movie.getMovieDetails()) {
		// x.setImg(constant.THUMBNAIL_IMAGE_URL + x.getImg());
		// }
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

		List<MovieInfo> movieList = new ArrayList<MovieInfo>();
		setUp(constant.SEARCH_MOVIE + search);

		for (MovieInfo filteredMovies : movie.getMovieDetails()) {
			if (StringUtils.containsIgnoreCase(filteredMovies.getName(), search)) {
				movieList.add(filteredMovies);
			}
			movie.setMovieDetails(movieList);
		}

		return movie;
	}

}
