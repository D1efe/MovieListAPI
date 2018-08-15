package com.qa.Domain;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

public class Movie {

	private String name;
	private String id;
	private String popularity;
	private String description;
	private List<String> genre;
	private String img;
	private String releaseDate;

	private JSONdata data;

	public Movie(String name) throws IOException, ParseException {
		data = new JSONdata(name);
		this.name = data.getjName();
		this.id = data.getjId();
		this.popularity = data.getjPopularity();
		this.description = data.getjDescription();
		// this.genre = data.getjGenre();
		this.img = data.getImageUrl();
		this.releaseDate = data.getjReleaseDate();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPopularity() {
		return popularity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public List<String> getGenre() {
		return genre;
	}	

	public String getImg() {
		return img;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}





}