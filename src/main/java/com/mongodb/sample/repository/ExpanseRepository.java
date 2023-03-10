package com.mongodb.sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongodb.sample.model.Expanse;

public interface ExpanseRepository extends MongoRepository<Expanse, String> {
	
	@Query("{ 'name' : ?0}")
	public Optional<Expanse> findByNameAlternative(String name);
	
	public List<Expanse> findByName(String name);

}
