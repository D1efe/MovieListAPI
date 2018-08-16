package com.qa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.Domain.Movie;
import com.qa.repository.MovieDBRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieDBRepository movieDB;
	
	public MovieService(MovieDBRepository movieDBRepository) {
		this.movieDB = movieDB;
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
	

}
