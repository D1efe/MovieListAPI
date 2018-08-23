package com.qa.Domain;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.qa.constants.Constants;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "title", "genre_ids", "popularity", "description", "img", "releaseDate" })

@Component
public class MovieInfo {

	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String name;
	@JsonProperty("genre_ids")
	private List<String> genres;
	@JsonProperty("popularity")
	private String popularity;
	@JsonProperty("overview")	
	private String description;
	@JsonProperty("poster_path")
	private String img;
	@JsonProperty("release_date")
	private String releaseDate;
	
	private Constants constant;

	public MovieInfo() {

	}

	public MovieInfo(String id, String name, List<String> genres, String popularity, String description, String img, String releaseDate) {
		this.id = id;
		this.name = name;
		this.genres = genres;
		this.popularity = popularity;
		this.description = description;
		this.img = constant.THUMBNAIL_IMAGE_URL + img;
		this.releaseDate = releaseDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	
	public List<String> getGenres() {
		return genres;
	}
	
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getPopularity() {
		return popularity;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getImg() {
		return img;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getReleaseDate() {
		return releaseDate;
	}

}