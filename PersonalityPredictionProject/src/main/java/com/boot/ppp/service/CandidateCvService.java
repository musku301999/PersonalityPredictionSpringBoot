package com.boot.ppp.service;

import java.util.List;

import com.boot.ppp.beans.CandidateCv;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;

//Interface defining All methods
public interface CandidateCvService {

	List<CandidateCv> getAllCandiateCv();

	CandidateCv getCandidateCvById(long id) throws ResourceNotFoundException;

	CandidateCv getCandidateCvByEmail(String email) throws ResourceNotFoundException;

	CandidateCv createCandidateCv(CandidateCv e) throws ResourceAlreadyExistsException;

	void updateCandidateCv(CandidateCv cv) throws ResourceNotFoundException;

	List<CandidateCv> getCandidateCvByQualification(String qualification) throws ResourceNotFoundException;

	void removeCv(long id) throws ResourceNotFoundException;

	List<CandidateCv> getByExperience(int experience) throws ResourceNotFoundException;

	List<CandidateCv> getBySkill(String skill) throws ResourceNotFoundException;
}
