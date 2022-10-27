package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Application;
import com.pk.recruiter.model.Job;
import com.pk.recruiter.model.JobSeeker;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	

	List<Application> findByJobSeeker(JobSeeker jobSeeker);

	List<Application> findByJobSeekerAndJob(JobSeeker jobSeeker, Job job);

	List<Application> findByJobSeekerAndJobAndStatus(JobSeeker jobSeeker, Job job, boolean b);

	List<Application> findByJobSeekerAndStatus(JobSeeker jobSeeker, boolean b);



}
