package com.qa.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "id", "popularity", "description", "img", "releaseDate" })

@Entity
public class Movie {

	@Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("title")
	private String name;
	@JsonProperty("popularity")
	private String popularity;
	@JsonProperty("overview")
	private String description;
	@JsonProperty("img")
	private String img;
	@JsonProperty("release_date")
	private String releaseDate;

	public Movie() {

	}

	public Movie(String id, String name, String popularity, String description, String img, String releaseDate) {
		this.id = id;
		this.name = name;
		this.popularity = popularity;
		this.description = description;
		this.img = img;
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