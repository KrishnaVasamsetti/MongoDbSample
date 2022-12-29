package com.mongodb.sample.model;

import org.springframework.data.annotation.Id;

public class PhotoInfo {
	@Id
	private String id;

	private String title;

	private String photoUrl;

	public PhotoInfo() {

	}

	public PhotoInfo(String id, String title, String photoUrl) {
		super();
		this.id = id;
		this.title = title;
		this.photoUrl = photoUrl;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}


}
