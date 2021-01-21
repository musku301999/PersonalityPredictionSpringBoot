package com.boot.ppp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.boot.ppp.beans.CandidateCv;
import com.boot.ppp.exception.ResourceAlreadyExistsException;
import com.boot.ppp.exception.ResourceNotFoundException;
import com.boot.ppp.repository.CvRepo;

@Transactional
@Service
public class CandidateCvServiceImpl implements CandidateCvService {

	@Autowired
	CvRepo repository;// Autowiring the repository to access its method

	// Method to get All Candidate Cv
	@Override
	public List<CandidateCv> getAllCandiateCv() {
		return (List<CandidateCv>) repository.findAll();
	}

//Method to create Candidate Cv
	@Override
	public CandidateCv createCandidateCv(CandidateCv e) throws ResourceAlreadyExistsException {
		if (!StringUtils.isEmpty(e.getCandId()) && !StringUtils.isEmpty(e.getCandidateName())
				&& !StringUtils.isEmpty(e.getEmail()) && !StringUtils.isEmpty(e.getExperience())
				&& !StringUtils.isEmpty(e.getPhoneNo()) && !StringUtils.isEmpty(e.getQualification())
				&& !StringUtils.isEmpty(e.getSkill())) {
			if (repository.findById(e.getCandId()) != null && repository.existsById(e.getCandId())) {
				throw new ResourceAlreadyExistsException("Candidate with id: " + e.getCandId() + " already exists");
			}
			return repository.save(e);
		} else {
			return repository.save(e);
		}

	}

//Method to get Candidate Cv by email
	@Override
	public CandidateCv getCandidateCvByEmail(String email) throws ResourceNotFoundException {
		CandidateCv cand = repository.findByEmail(email);
		if (cand == null)
			throw new ResourceNotFoundException("Cannot find candidate with email " + email);
		else
			return cand;
	}

	// Method to get Candidate Cv by qualification
	@Override
	public List<CandidateCv> getCandidateCvByQualification(String qualification) throws ResourceNotFoundException {
		List<CandidateCv> cand = repository.findByQualification(qualification);
		if (cand == null)
			throw new ResourceNotFoundException("Cannot find candidate with qualification " + qualification);

		else
			return cand;
	}

	// Method to get Candidate Cv by experience
	@Override
	public List<CandidateCv> getByExperience(int experience) throws ResourceNotFoundException {
		List<CandidateCv> cand = repository.findByExperience(experience);
		if (cand == null)
			throw new ResourceNotFoundException("Cannot find candidate with experience " + experience);
		else
			return cand;
	}

	// Method to get Candidate Cv by skills
	@Override
	public List<CandidateCv> getBySkill(String skill) throws ResourceNotFoundException {
		List<CandidateCv> cand = repository.findBySkill(skill);
		if (cand == null)
			throw new ResourceNotFoundException("Cannot find candidate with skill " + skill);
		else
			return cand;
	}

	// Method to update Candidate Cv
	@Override
	public void updateCandidateCv(CandidateCv cv) throws ResourceNotFoundException {
		Long id = cv.getCandId();
		if (!repository.existsById(id))
			throw new ResourceNotFoundException("Cannot find candiadte with id " + id);
		else
			repository.saveAndFlush(cv);
	}

	// Method to remove Candidate Cv
	@Override
	public void removeCv(long id) throws ResourceNotFoundException {
		if (!repository.existsById(id))
			throw new ResourceNotFoundException("Cannot find candiadte with id " + id);
		else
			repository.deleteById(id);
	}

	// Method to get Candidate Cv by Id
	@Override
	public CandidateCv getCandidateCvById(long id) throws ResourceNotFoundException {
		CandidateCv cand = repository.findById(id).orElse(null);
		if (cand == null)
			throw new ResourceNotFoundException("Cannot find candidate with id " + id);
		else
			return cand;
	}

}
