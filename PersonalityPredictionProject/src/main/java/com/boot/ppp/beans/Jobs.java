package com.boot.ppp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "job")	

public class Jobs {

	@Id
	@Column(name = "job_id")	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobId;

	@NotNull
	@Size(min= 2, message = "Job description should have at least 2 characters")
	@Column(name = "job_des")
	private String jobDes;

	@NotNull
	@Size(min= 2, message = "Required Skill should have at least 2 characters")
	@Column(name = "req_skills")
	private String reqSkills;

	@NotNull
	@Column(name = "experience")
	private String experience;

	@NotNull
	@Size(min= 2, message = "Qualification should have at least 2 characters")
	@Column(name = "qualification")
	private String qualification;
	
	//Default constructor
	public Jobs() {
		super();
	}

	//Parameterized constructor
	public Jobs(int jobId, String jobDes, String reqSkills, String experience, String qualification) {
		super();
		this.jobId = jobId;
		this.jobDes = jobDes;
		this.reqSkills = reqSkills;
		this.experience = experience;
		this.qualification = qualification;
	}

	//getters and setters
	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDes() {
		return jobDes;
	}

	public void setJobDes(String jobDes) {
		this.jobDes = jobDes;
	}

	public String getReqSkills() {
		return reqSkills;
	}

	public void setReqSkills(String reqSkills) {
		this.reqSkills = reqSkills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	//Overriding toString method
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobDes=" + jobDes + ", reqSkills=" + reqSkills + ", experience=" + experience
				+ ", qualification=" + qualification + "]";
	}

}

