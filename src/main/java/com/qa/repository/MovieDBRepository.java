package com.qa.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.Domain.Movie;

public interface MovieDBRepository extends CrudRepository<Movie, Long> {

}
