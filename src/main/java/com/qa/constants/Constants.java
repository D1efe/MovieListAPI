package com.qa.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	
	private String pattern = "yyyy-MM-dd";
	private final String CURRENT_DATE = new SimpleDateFormat(pattern).format(new Date());
	
	//API key provided by TMDb
	public final String API_KEY_V3 = "f000b5430a909fe857a7de49bf27895e";
	public final String API_KEY_V4 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMDAwYjU0MzBhOTA5ZmU4NTdhN2RlNDliZjI3ODk1ZSIsInN1YiI6IjViNzJmYjkzYzNhMzY4MTg4NjIwM2M5MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9hDF5VM45mPvWA5GxTERRcK_V1GZH-tABBZ7nrAp4mU";
	
	//Movie page URL's with my api-key
	public final String CURRENT_MOVIE = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&language=en-US&page=1";
	public final String UPCOMING_MOVIE = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&language=en-US&page=1&year=" + CURRENT_DATE;

	//Followed by a name to query specific film

	public final String SEARCH_MOVIE = "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY_V3 +"&language=en-US&page=1&include_adult=false&primary_release_year=" + CURRENT_DATE + "&query=";
	
	//sizes are: w500, w780, w342, w185, w154, w92
	//baseurl + size + file_path
	public final String THUMBNAIL_IMAGE_URL = "https://image.tmdb.org/t/p/w154";
	public final String POSTER_IMAGE_URL = "https://image.tmdb.org/t/p/w500";
	
	//list of genres
	public final String GENRE_LIST =  "https://api.themoviedb.org/3/genre/movie/list?api_key=" + API_KEY_V3 + "&language=en-US";

}