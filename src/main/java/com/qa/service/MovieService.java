package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Movie;
import com.qa.constants.Constants;
import com.qa.repository.MovieDBRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieDBRepository movieDB;
	
	private Constants constant;
	
	public MovieService(MovieDBRepository movieDBRepository) {
		this.movieDB = movieDB;
	}
	
	private void setUp() {
		RestTemplate rest = new RestTemplate();
		Movie movie = rest.getForObject(constant.MOVIE_URL_1, Movie.class);
	}
	
	public Movie everyMovie() {
		
		RestTemplate rest = new RestTemplate();
		Movie movie = rest.getForObject(constant.MOVIE_URL_1, Movie.class);
		return null;
		
	}
	
	//list all movies
	public Iterable<Movie> allMovies(){
		return movieDB.findAll();
	}
	
	//save a single movie
	public Movie save(Movie movie) {
		return movieDB.save(movie);
	}
	
	//save multiple movies
	public Iterable<Movie> allMovies(List<Movie> movies) {
		return movieDB.saveAll(movies);
	}
	
	private List<Movie> dataMap() {
		RestTemplate rest = new RestTemplate();
		Movie movie = rest.getForObject(constant.MOVIE_URL_1, Movie.class);
		return movie;
	}
	
	

}
