package com.demo.entity;
import jakarta.persistence.*;

@Entity
public class Student {
	@Id
	private long id;
	
	private String name;
	
	private String email;
	
	private int fee;
	
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
		
}
