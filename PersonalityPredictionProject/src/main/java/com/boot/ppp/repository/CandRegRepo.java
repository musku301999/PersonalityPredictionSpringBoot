package com.boot.ppp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.ppp.beans.Candidate;

@Repository
public interface CandRegRepo extends JpaRepository<Candidate, Long> {

}
