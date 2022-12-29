package com.mongodb.sample.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.sample.model.Photo;
import com.mongodb.sample.model.PhotoInfo;
import com.mongodb.sample.repository.PhotoRepository;
import com.mongodb.sample.service.PhotoService;

@RestController
@RequestMapping("api/photo")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@PostMapping
	public String addPhoto(@RequestPart MultipartFile image) throws IOException {
		String id = photoService.addPhoto(image.getOriginalFilename(), image);
		return id;
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Resource> downloadPhoto(@PathVariable String id) {
		Photo photo = photoService.downloadPhoto(id);
		Resource resource = new ByteArrayResource(photo.getPhoto().getData());
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+photo.getTitle()+"\"")
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		
	}
	
	@GetMapping(path = "/all")
	public List<PhotoInfo> getAllPhotoDetails() {
		return photoService.getAllPhotoDetails();
	}
	
	@DeleteMapping(path = "/{id}")
	public String deletePhotoById(@PathVariable String id) {
		photoService.deletePhotoById(id);
		return "Photo deleted sucessfully";
	}
	
}
