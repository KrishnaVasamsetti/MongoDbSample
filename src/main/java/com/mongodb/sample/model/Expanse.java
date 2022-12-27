package com.mongodb.sample.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Expanse {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String name;
	
	private ExpanseCategory category;
	
	@Field(name = "amount")
	private BigDecimal amount;


	public Expanse(String id, String name, ExpanseCategory category, BigDecimal amount) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.amount = amount;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExpanseCategory getCategory() {
		return category;
	}

	public void setCategory(ExpanseCategory category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
