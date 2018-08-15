package com.qa.Domain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.qa.constants.Constants;

public class JSONdata {

	private Constants constant = new Constants();
	private String fetchData;

	private String jName;
	private String jId;
	private String jPopularity;
	private String jDescription;
	private List<String> jGenre;
	private String imageUrl;
	private String jReleaseDate;

	// get a specific film
	public JSONdata(String name) throws IOException, ParseException {

		URL url = new URL(constant.MOVIE_SEARCH_URL + name);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();

		if (responsecode != 200)
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		else {
			Scanner sc = new Scanner(url.openStream());
			while (sc.hasNext()) {
				fetchData += sc.nextLine();
			}
			System.out.println("\nJSON data in string format");
			System.out.println(fetchData);
			sc.close();
		}

		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject) parse.parse(fetchData);
		JSONArray jarray1 = (JSONArray) jobj.get("results");

		// Get data for Results array

		for (int i = 0; i < jarray1.size(); i++)

		{

			JSONObject jsonobj_1 = (JSONObject) jarray1.get(i);

			this.jName = (String) jsonobj_1.get("title");
			this.jId = (String) jsonobj_1.get("id");
			this.jPopularity = (String) jsonobj_1.get("popularity");
			this.jDescription = (String) jsonobj_1.get("overview");
			this.jReleaseDate = (String) jsonobj_1.get("poster_path");
			this.imageUrl = (String) jsonobj_1.get("poster_path");

		}

	}

	public String getjId() {
		return jId;
	}

	public String getjName() {
		return jName;
	}

	public String getjPopularity() {
		return jPopularity;
	}

	public String getjDescription() {
		return jDescription;
	}

	public List<String> getjGenre() {
		return jGenre;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getjReleaseDate() {
		return jReleaseDate;
	}

}
