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

import com.boot.ppp.beans.CandidateCv;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;
import com.boot.ppp.service.CandidateCvService;

@RestController()
@RequestMapping("/candidateCv")
public class CandidateCvController {

	@Autowired
	CandidateCvService service;
	
	//get all the candidate cv
	@GetMapping("/admin/getAllCandidate")
	public List<CandidateCv> getAllCandidateCv() {
		return service.getAllCandiateCv();
	}
	
	// get candidate cv by id
	@GetMapping("/admin/getById/{id}")
	public ResponseEntity<?> getCandidateCvById(@PathVariable("id") long id) {
		try {
			CandidateCv cand = service.getCandidateCvById(id);
			return ResponseEntity.ok(cand); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find cv with id " + id); // return 404, with specific msg
		}
	}

	// get candidate cv by email id
	@GetMapping("/get/{email}")
	public ResponseEntity<?> getCandidateCvByEmail(@PathVariable("email") String email) {
		try {
			CandidateCv cand = service.getCandidateCvByEmail(email);
			return ResponseEntity.ok(cand); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find cv with email " + email); // return 404, with specific msg
		}
	}
	
	// get candidate cv by qualification
	@GetMapping("/admin/getByQual/{qualification}")
	public ResponseEntity<?> getCandidateCvByQualification(@PathVariable("qualification") String qualification) {
		try {
			List<CandidateCv> cand = service.getCandidateCvByQualification(qualification);
			return ResponseEntity.ok(cand); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find cv with qualification " + qualification); // return 404, with specific msg
		}
	}
	
	// get candidate cv by experience
	@GetMapping("/admin/getByExp/{experience}")
	public ResponseEntity<?> getCandidateCvByExperience(@PathVariable("experience") int experience) {
		try {
			List<CandidateCv> cand = service.getByExperience(experience);
			return ResponseEntity.ok(cand); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find cv with experience " + experience); // return 404, with specific msg
		}
	}
	
	// get candidate cv by skill	
	@GetMapping("/admin/getBySkill/{skill}")
	public ResponseEntity<?> getCandidateCvBySkill(@PathVariable("skill") String skill) {
		try {
			List<CandidateCv> cand = service.getBySkill(skill);
			return ResponseEntity.ok(cand); // return 200, with json body
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find cv with skill " + skill); // return 404, with specific msg
		}
	}

	// create candidate cv
	@PostMapping("/create")
	public ResponseEntity<?> createCandidateCv(@Valid @RequestBody CandidateCv cv) {
		try {
			CandidateCv cand = service.createCandidateCv(cv);
			return ResponseEntity.ok(cand);
		} catch (ResourceAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CV already exists with id " + cv.getCandId());
		}
	}
	
	// update candidate cv
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody CandidateCv cv) {
		try {
			service.updateCandidateCv(cv);;
			return ResponseEntity.ok().body("Cv with id " + cv.getCandId() +" Updated Successfully");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update Failed!!! Does not found cv with id " + cv.getCandId());
		}
	}
	
	// delete candidate cv
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteJob( @PathVariable("id") int id) {	
		try {
			service.removeCv(id);;
			return ResponseEntity.ok().body("Cv with id " + id +" Deleted Successfully");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Delete Failed!!! Does not found cv with id " + id); // return 404, with specific msg
		}
	}
}
