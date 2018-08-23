package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Genre;
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
		List<String> genreNamesList;
		int count;

		for (MovieInfo genreList : movie.getMovieDetails()) {
			genreNamesList = new ArrayList<>();
			for (String genreId : genreList.getGenres()) {
				for(count = 0; count < genres.getGenreDetails().size(); count++) {
					if (genres.getGenreDetails().get(count).getId().matches(genreId)) {
						genreNamesList.add(genres.getGenreDetails().get(count).getName());
					}
				}
			}
			genreList.setGenres(genreNamesList);
		}
	}

	private void genreSetUp() {
		RestTemplate rest = new RestTemplate();
		genres = rest.getForObject(constant.GENRE_LIST, Genre.class);
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
