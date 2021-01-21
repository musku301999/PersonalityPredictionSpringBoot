package com.boot.ppp.service;

import java.util.List;
//import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.boot.ppp.beans.Jobs;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;
import com.boot.ppp.repository.JobRepository;

@Transactional
@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobRepository jobRepo;
	
	@SuppressWarnings("deprecation")
	@Override
	public Jobs addJobs(Jobs jobs) throws ResourceAlreadyExistsException {
		if(!StringUtils.isEmpty(jobs.getJobDes()) && !StringUtils.isEmpty(jobs.getQualification()) && 
				!StringUtils.isEmpty(jobs.getExperience()) && !StringUtils.isEmpty(jobs.getReqSkills())){
			
			if (jobRepo.findById(jobs.getJobId()) != null && jobRepo.existsById(jobs.getJobId())) {
				throw new ResourceAlreadyExistsException("Job with id: " + jobs.getJobId() + " already exists");
			}
			return jobRepo.save(jobs);
		}
		else {
			return null;
		}	
	}

	@Override
	public Jobs getJobs(int id) throws ResourceNotFoundException {
		Jobs job = jobRepo.findById(id).orElse(null);
		if (job == null)
			throw new ResourceNotFoundException("Cannot find job with id " + id);
		else
			return job;
	}

	@Override
	public List<Jobs> getJobList() {
		return (List<Jobs>) jobRepo.findAll();
	}

	@Override
	public void removeJobs(int id) throws ResourceNotFoundException {
		if (!jobRepo.existsById(id))
			throw new ResourceNotFoundException("Cannot find job with id ");
		else
			jobRepo.deleteById(id);
	}

	@Override
	public void updateJobs(Jobs jobs) throws ResourceNotFoundException {
		int id = jobs.getJobId();
		if (!jobRepo.existsById(id))
			throw new ResourceNotFoundException("Cannot find job with id ");
		else
			jobRepo.saveAndFlush(jobs);
	}

	@Override
	public List<Jobs> getByJobDes(String des) throws ResourceNotFoundException {
		List<Jobs> job = jobRepo.findByJobDes(des);
		if (job == null)
			throw new ResourceNotFoundException("Cannot find job with des");
		else
			return job;
	}

	@Override
	public List<Jobs> getByReqSkill(String reqSkill) throws ResourceNotFoundException {
		List<Jobs> job = (List<Jobs>) jobRepo.findByReqSkills(reqSkill);
		if (job == null)
			throw new ResourceNotFoundException("Cannot find job with skill");
		else
			return (List<Jobs>) job;
	}

	@Override
	public List<Jobs> getByExperience(String experience) throws ResourceNotFoundException {
		List<Jobs> job = jobRepo.findByExperience(experience);
		if (job == null)
			throw new ResourceNotFoundException("Cannot find job with experience");
		else
			return job;
	}

	@Override
	public List<Jobs> getByQualification(String qualification) throws ResourceNotFoundException {
		List<Jobs> job = jobRepo.findByQualification(qualification);
		if (job == null)
			throw new ResourceNotFoundException("Cannot find job with qualification");
		else
			return (List<Jobs>) job;
	}

}
