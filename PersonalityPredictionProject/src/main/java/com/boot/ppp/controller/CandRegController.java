package com.boot.ppp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.ppp.beans.Candidate;
import com.boot.ppp.exception.ResourceNotFoundException;
import com.boot.ppp.repository.CandRegRepo;

@RestController
@RequestMapping("/candidateReg")
public class CandRegController {

	@Autowired
	private CandRegRepo candregrepo;

//get candidate
	 @GetMapping("/getall")
	    public List<Candidate> getAllCandidates() {
	        return candregrepo.findAll();
	    }
	 
//get candidate by id
	 @GetMapping("/get/{id}")
	    public ResponseEntity<Candidate> getCandidateById(@PathVariable(value = "id") Long candidateId)
	        throws ResourceNotFoundException {
		 Candidate candidate = candregrepo.findById(candidateId)
	          .orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));
	        return ResponseEntity.ok().body(candidate);
	    } 
	 
//add candidate
	 @PostMapping("/create")
	    public Candidate createCandidate(@Validated @RequestBody Candidate candidate) {
	        return candregrepo.save(candidate);
	    }	 
	 
//update candidate
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Candidate> updateCandidate(@PathVariable(value = "id") Long candidateId,
	         @Validated @RequestBody Candidate candidateDetails) throws ResourceNotFoundException {
		 Candidate candidate = candregrepo.findById(candidateId)
	        .orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

		 candidate.setEmail(candidateDetails.getEmail());
		 candidate.setName(candidateDetails.getName());
		 candidate.setPassword(candidateDetails.getPassword());
		 candidate.setMobileNumber(candidateDetails.getMobileNumber());
	        final Candidate updatedCandidate = candregrepo.save(candidate);
	        return ResponseEntity.ok(updatedCandidate);
	    } 
	 
//delete candidate
	 @DeleteMapping("/delete/{id}")
	    public Map<String, Boolean> deleteCandidate(@PathVariable(value = "id") Long candidateId)
	         throws ResourceNotFoundException {
		 Candidate candidate = candregrepo.findById(candidateId)
	       .orElseThrow(() -> new ResourceNotFoundException("Candidate not found for this id :: " + candidateId));

		 candregrepo.delete(candidate);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	 }
}