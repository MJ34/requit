package com.pk.recruiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {

}
