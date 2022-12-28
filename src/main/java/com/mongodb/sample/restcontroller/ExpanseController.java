package com.mongodb.sample.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.sample.model.Expanse;
import com.mongodb.sample.service.ExpanseService;

@RestController
@RequestMapping("/api/expanse")
public class ExpanseController {
	
	@Autowired
	ExpanseService expanseService;
	
	@PostMapping("add")
	public String addExpanse(@RequestBody Expanse expanse) {
		expanseService.addExpanse(expanse);
		return "Added expanse successfully";
	}
	
	@PutMapping("update")
	public String updateExpanse(@RequestBody Expanse expanse) {
		expanseService.updateExpanse(expanse);
		return "Updated expanse successfully";
	}
	
	@DeleteMapping
	public String deleteExpanse(@RequestBody Expanse expanse) {
		expanseService.deleteExpanse(expanse);
		return "Deleted expanse successfully";
	}
	
	@GetMapping("/id/{id}")
	public Expanse getExpanseById(@PathVariable("id") String id) {
		return expanseService.getExpanseById(id);
	}
	
	@GetMapping("/name/{name}")
	public Expanse getExpanseByName(@PathVariable("name") String name) {
		return expanseService.getExpanseByName(name);
	}
	
	@GetMapping("/byName/{name}")
	public List<Expanse> findExpanseByName(@PathVariable("name") String name) {
		return expanseService.findByName(name);
	}
	
	@GetMapping("info")
	public String getInfo() {
		return "Expanse Api information";
	}
	
	@GetMapping("all")
	public List<Expanse> getAllExpanses() {
		return expanseService.getAllExpanses();
	}

}
