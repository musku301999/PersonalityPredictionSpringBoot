package com.boot.ppp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.ppp.beans.CandidateCv;

//Repository to store details of Candidate CV.
@Repository
public interface CvRepo extends JpaRepository<CandidateCv, Long> {
	// Method to find Cv by Email
	public CandidateCv findByEmail(String email);

	// Method to find all Cv by qualification
	List<CandidateCv> findByQualification(String qualification);

	// Method to find all Cv by experience
	List<CandidateCv> findByExperience(int experience);

	// Method to find all Cv by skill
	List<CandidateCv> findBySkill(String skill);

}
