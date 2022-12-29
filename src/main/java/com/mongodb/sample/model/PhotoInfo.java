package com.mongodb.sample.model;

import org.springframework.data.annotation.Id;

public class PhotoInfo {
	@Id
	private String id;

	private String title;

	
	public PhotoInfo() {
		
	}
	
	public PhotoInfo(String id, String title) {
		super();
		this.id = id;
		this.title = title;
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

}
