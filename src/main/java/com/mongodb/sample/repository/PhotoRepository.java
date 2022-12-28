package com.mongodb.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.sample.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String>{

}
