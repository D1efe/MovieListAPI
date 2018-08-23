package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Genre;
import com.qa.Domain.GenreInfo;
import com.qa.Domain.Movie;
import com.qa.Domain.MovieInfo;
import com.qa.constants.Constants;

@Service
public class MovieService {

	@Autowired
	private Movie movie;

	@Autowired
	private Genre genres;

	@Autowired
	private Constants constant;

	private void movieSetUp(String url) {
		RestTemplate rest = new RestTemplate();
		movie = rest.getForObject(url, Movie.class);

		genreSetUp();
		List<String> movieIdHolder = new ArrayList<>();

		for (MovieInfo genreList : movie.getMovieDetails()) {
			int count = 0;
			for (String genreID : genreList.getGenres()) {
				if (genreID.equals(genres.getGenreDetails().get(count).getId())) {
					movieIdHolder.add(genres.getGenreDetails().get(count).getName());
					count++;
				}
			}
			genreList.setGenres(movieIdHolder);
		}
	}

	private void genreSetUp() {
		RestTemplate rest = new RestTemplate();
		genres = rest.getForObject(constant.GENRE_LIST, Genre.class);
	}

	public List<String> loopTest() {
		List<String> checkMe = new ArrayList<>();
		int count = 0;
		while(count < 10) {
			checkMe.add("" + count);
			count++;
		}
		return checkMe;
	}

	public Movie currentMovies() {
		movieSetUp(constant.CURRENT_MOVIE);
		return movie;
	}

	public Movie upcomingMovies() {
		movieSetUp(constant.UPCOMING_MOVIE);
		return movie;
	}

	public Movie findMovie(String search) {

		List<MovieInfo> movieList = new ArrayList<MovieInfo>();
		movieSetUp(constant.SEARCH_MOVIE + search);

		for (MovieInfo filteredMovies : movie.getMovieDetails()) {
			if (StringUtils.containsIgnoreCase(filteredMovies.getName(), search)) {
				movieList.add(filteredMovies);
			}
			movie.setMovieDetails(movieList);
		}

		return movie;
	}

}
