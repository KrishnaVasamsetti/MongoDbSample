package com.mongodb.sample.service;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.sample.model.Photo;
import com.mongodb.sample.model.PhotoInfo;
import com.mongodb.sample.repository.PhotoRepository;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepository;

	public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
		Photo photo = new Photo();
		photo.setTitle(originalFilename);
		photo.setPhoto(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
		return photoRepository.save(photo).getId();
	}

	public Photo downloadPhoto(String id) {
		Photo photo = photoRepository.findById(id).get();
		return photo;
	}

	public List<PhotoInfo> getAllPhotoDetails(String path) {
		List<PhotoInfo> allPhotos = photoRepository.findAll().stream()
				.map(item -> new PhotoInfo(item.getId(), item.getTitle(), path + "/" + item.getId())).toList();
		return allPhotos;
	}

	public void deletePhotoById(String id) {
		photoRepository.deleteById(id);
	}

}
