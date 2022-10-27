package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	List<Skills> findByJobSeeker(JobSeeker jobSeeker);

	
}
