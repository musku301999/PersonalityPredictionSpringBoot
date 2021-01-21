package com.boot.ppp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "cand_reg")
public class Candidate {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Column(name = "password")
	@Size(min = 6, max = 13)
	private String password;
	
	@NotNull
	@Column(name = "mobileNumber")
	private Long mobileNumber;
	
	//Default constructor
	public Candidate() {
		super();
	}

	//Parameterized constructor
	public Candidate(@NotBlank String name, @NotBlank @Email String email,
			@NotBlank @Size(min = 6, max = 13) String password, @NotNull Long mobileNumber) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	//getters and setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	//Overriding toString method
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + "]";
	}	
	
}