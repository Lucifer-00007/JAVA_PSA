package com.marketing.entity;

import jakarta.persistence.*;

@Entity
@Table(name="register")
public class Registration {
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name", length=10, nullable=false)
	private String name;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="mobile", unique=true, nullable=false)
	private long phone;

	@Column(name="city", nullable=false)
	private String city;
}
