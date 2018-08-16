package com.qa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.qa.Domain.Movie;
import com.qa.constants.Constants;

@SpringBootApplication(scanBasePackages="com.qa")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private Constants constant;

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Movie movie = restTemplate.getForObject(constant.MOVIE_URL_1, Movie.class);
		};
	}
}

	