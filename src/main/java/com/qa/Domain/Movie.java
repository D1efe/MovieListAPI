package com.qa.Domain;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Component
public class Movie {
	
	@JsonProperty("results")
	private Movie movieDetails[];

	public Movie (Movie[] movieDetails) {
		this.movieDetails = movieDetails;
	}
	
	public Movie() {
		
	}
	
	public void setMovieDetails(Movie[] movieDetails) {
		this.movieDetails = movieDetails;
	}
	
	public Movie[] getMovieDetails() {
		return movieDetails;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
