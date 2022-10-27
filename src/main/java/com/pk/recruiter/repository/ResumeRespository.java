package com.pk.recruiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Resume;

public interface ResumeRespository extends JpaRepository<Resume, Integer> {
	
	
}
