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
@Table(name = "cand_info")
public class CandidateCv {

	@Id
	@Column(name = "cand_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long candId;

	@NotNull
	@Size(min = 2, message = "Job description should have at least 2 characters")
	@Column(name = "cand_name")
	private String candidateName;

	@NotNull
	@Email
	@Column(name = "email", unique = true)
	private String email;

	@NotNull
	@Column(name = "phone_no")
	private String phoneNo;

	@NotNull
	@Size(min = 2, message = "Job description should have at least 2 characters")
	@Column(name = "qualification")
	private String qualification;

	@NotNull
	@Column(name = "exp")
	private String experience;

	@NotNull
	@Size(min = 2, message = "Job description should have at least 2 characters")
	@Column(name = "skill")
	private String skill;

	// default constructor
	public CandidateCv() {
		super();
	}

	// parameterized constructor

	public CandidateCv(Long candId,
			@NotNull @Size(min = 2, message = "Job description should have at least 2 characters") String candidateName,
			@NotNull @Email String email, @NotNull String phoneNo,
			@NotNull @Size(min = 2, message = "Job description should have at least 2 characters") String qualification,
			@NotNull String experience,
			@NotNull @Size(min = 2, message = "Job description should have at least 2 characters") String skill) {
		super();
		this.candId = candId;
		this.candidateName = candidateName;
		this.email = email;
		this.phoneNo = phoneNo;
		this.qualification = qualification;
		this.experience = experience;
		this.skill = skill;
	}

	// getters and setters
	public Long getCandId() {
		return candId;
	}

	public void setCandId(Long candId) {
		this.candId = candId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	// overriding toString method
	@Override
	public String toString() {
		return "CandidateCv [candId=" + candId + ", candidateName=" + candidateName + ", email=" + email + ", phoneNo="
				+ phoneNo + ", qualification=" + qualification + ", experience=" + experience + ", skill=" + skill
				+ "]";
	}

}
