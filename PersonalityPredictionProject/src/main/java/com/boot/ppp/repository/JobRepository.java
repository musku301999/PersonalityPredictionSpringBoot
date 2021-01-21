package com.boot.ppp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.ppp.beans.Jobs;

@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer>{

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Jobs u WHERE u.jobDes = ?1")
	public Boolean existsByJobDes(String jobDes);
	public List<Jobs> findByJobDes(String jobDes);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Jobs u WHERE u.qualification = ?1")
	public Boolean existsByQualification(String qualification);
	public List<Jobs> findByQualification(String qualification);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Jobs u WHERE u.experience = ?1")
	public Boolean existsByExperience(String experience);
	public List<Jobs> findByExperience(String experience);
	
	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM Jobs u WHERE u.reqSkills = ?1")
	public Boolean existsByReqSkills(String reqSkills);
	public List<Jobs> findByReqSkills(String reqSkills);
	
	
}
