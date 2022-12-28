package com.mongodb.sample.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Photo {
	
	@Id
	private String id;

	private String title;
	
	private Binary photo;
	
	public Photo() {
		
	}
	
	public Photo(String id, String title, Binary photo) {
		super();
		this.id = id;
		this.title = title;
		this.photo = photo;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Binary getPhoto() {
		return photo;
	}

	public void setPhoto(Binary photo) {
		this.photo = photo;
	}

}
