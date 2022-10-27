package com.pk.recruiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.JobSeeker;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	

}
