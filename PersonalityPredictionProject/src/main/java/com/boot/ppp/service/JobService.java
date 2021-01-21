package com.boot.ppp.service;

import java.util.List;

import com.boot.ppp.beans.Jobs;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;

public interface JobService {
	
	public Jobs addJobs(Jobs jobs) throws ResourceAlreadyExistsException;
	
	public Jobs getJobs(int id) throws ResourceNotFoundException;
	
	public List<Jobs> getJobList();
	
	public void removeJobs(int id) throws ResourceNotFoundException;
	
	public void updateJobs(Jobs jobs) throws ResourceNotFoundException;
	
	public List<Jobs> getByJobDes(String des) throws ResourceNotFoundException;
	
	public List<Jobs> getByReqSkill(String reqSkills) throws ResourceNotFoundException;
	
	public List<Jobs> getByExperience(String experience) throws ResourceNotFoundException;
	
	public List<Jobs> getByQualification(String qualification) throws ResourceNotFoundException;
	
}
