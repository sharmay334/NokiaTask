package com.nokia.nokiamain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_accounts")
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)	
	private Long id;
	@Column(name = "name", length = 100, nullable = false)
	private String name;
	@Column(name = "phone", nullable = false)
	private Long phone;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "address")
	private String address;
	@Column(name = "country", nullable = false)
	private String country;
	@Column(name = "department", nullable = false)
	private String department;
	public User() {
		super();
	}
	public User(Long id, String name, Long phone, String email, String address, String country, String department) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.department = department;
	}
	
	
	
}
