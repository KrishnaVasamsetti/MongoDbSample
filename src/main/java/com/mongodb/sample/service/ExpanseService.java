package com.mongodb.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.sample.model.Expanse;
import com.mongodb.sample.repository.ExpanseRepository;

@Service
public class ExpanseService {

	
	@Autowired
	ExpanseRepository expanseRepository;
	
	public void addExpanse(Expanse expanse) {
			
		expanseRepository.insert(expanse);
		
	}
	
	public void updateExpanse(Expanse expanse) {
		
		Expanse savedExpanse = expanseRepository.findById(expanse.getId())
				.orElseThrow(() -> new RuntimeException("Expanse not found by given id "+ expanse.getId()));
		savedExpanse.setName(expanse.getName());
		savedExpanse.setAmount(expanse.getAmount());
		savedExpanse.setCategory(expanse.getCategory());
		expanseRepository.save(savedExpanse);
	}
	
	public void deleteExpanse(Expanse expanse) {
		expanseRepository.delete(expanse);
	}
	
	public Expanse getExpanseByName(String name) {
		Expanse expanse = expanseRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException("Expanse not found by given name "+ name));
		return expanse;
	}
	
	public Expanse getExpanseById(String id) {
		Expanse expanse = expanseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Expanse not found by given id "+ id));
		return expanse;
	}
	
	public List<Expanse> getAllExpanses() {
		List<Expanse> allExpanses = expanseRepository.findAll();
		return allExpanses;
	}
}
