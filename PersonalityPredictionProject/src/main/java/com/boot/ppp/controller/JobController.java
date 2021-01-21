package com.boot.ppp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ppp.beans.Jobs;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;
import com.boot.ppp.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	JobService service;

	// create job 
	@PostMapping("/admin/add")
	public ResponseEntity<?> addJob(@Valid @RequestBody Jobs jobs) {		
		try {
			Jobs job = service.addJobs(jobs);
			return ResponseEntity.ok(job);
		} catch (ResourceAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Job already exists with id " + jobs.getJobId());
		}
	}

	// get all the job
	@GetMapping("/getAllJob")
	public List<Jobs> getJobList() {
		return service.getJobList();
	}

	// get job by id
	@GetMapping("/admin/get/{id}")
	public ResponseEntity<?> getJob(@PathVariable("id") int id) {
		try {
			Jobs job = service.getJobs(id);
			return ResponseEntity.ok(job); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find job with id " + id); // return 404, with specific msg
		}
	}

	// get job by description
	@GetMapping("/candidate/getByJobDes/{jobDes}")
	public ResponseEntity<?> getJobByJobDes(@PathVariable("jobDes") String jobDes) {
		try {
			List<Jobs> job = service.getByJobDes(jobDes);
			return ResponseEntity.ok(job); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find job with description " + jobDes); // return 404, with specific  msg
		}
	}

	// get job by qualification
	@GetMapping("/candidate/getByQual/{qualification}")
	public ResponseEntity<?> getJobByQualification(@PathVariable("qualification") String qualification) {
		try {
			List<Jobs> job = service.getByQualification(qualification);
			return ResponseEntity.ok(job); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Cannot find job with qualification " + qualification); // return 404, with specific msg
		}
	}

	// get job by experience
	@GetMapping("/candidate/getByExp/{experience}")
	public ResponseEntity<?> getJobByExperience(@PathVariable("experience") String experience) {
		try {
			List<Jobs> job = service.getByExperience(experience);
			return ResponseEntity.ok(job); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find job with experience " + experience); // return 404, with specific msg
		}
	}

	// get job by skill
	@GetMapping("/candidate/getBySkill/{skill}")
	public ResponseEntity<?> getJobBySkill(@PathVariable("skill") String skill) {
		try {
			List<Jobs> job = service.getByReqSkill(skill);
			return ResponseEntity.ok(job); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find job with skill " + skill); // return 404, with specific msg
		}
	}

	// delete job
	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<?> deleteJob(@PathVariable("id") int id) {
		try {
			service.removeJobs(id);
			return ResponseEntity.ok().body("Job with id " + id +" Deleted Successfully");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Delete Failed!!! Does not found job with id " + id); // return 404, with specific msg
		}
	}

	// update job
	@PutMapping("/admin/update")
	public ResponseEntity<?> update(@RequestBody Jobs jobs) {
		try {
			service.updateJobs(jobs);
			return ResponseEntity.ok().body("Job with id " + jobs.getJobId() +" Updated Successfully");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update Failed!!! Does not found job with id " + jobs.getJobId());
		}
	}

}
