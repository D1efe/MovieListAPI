package com.qa.Domain;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name" })

@Component
public class GenreInfo {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;

	public GenreInfo() {

	}

	public GenreInfo(String id, String name) {
		this.id = id;
		this.name = name;
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

}
