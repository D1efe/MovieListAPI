package com.qa.constants;

public class Constants {
	
	//API key provided by TMDb
	public final String API_KEY_V3 = "f000b5430a909fe857a7de49bf27895e";
	public final String API_KEY_V4 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMDAwYjU0MzBhOTA5ZmU4NTdhN2RlNDliZjI3ODk1ZSIsInN1YiI6IjViNzJmYjkzYzNhMzY4MTg4NjIwM2M5MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.9hDF5VM45mPvWA5GxTERRcK_V1GZH-tABBZ7nrAp4mU";
	
	//Movie page URL's with my api-key
	public final String MOVIE_URL_1 = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&page=1";
	public final String MOVIE_URL_2 = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&page=2";
	public final String MOVIE_URL_3 = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&page=3";
	public final String MOVIE_URL_4 = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY_V3 + "&page=4";

	//Followed by a name to query specific film
	public final String MOVIE_SEARCH_URL = "https://api.themoviedb.org/3/search/movie?api_key="+ API_KEY_V3 +"&query=";
	
	//sizes are: w500, w780, w342, w185, w154, w92
	//baseurl + size + file_path
	public final String IMAGE_URL = "https://image.tmdb.org/t/p/";
}