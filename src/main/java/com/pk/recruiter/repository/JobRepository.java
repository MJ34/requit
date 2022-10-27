package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Job;
import com.pk.recruiter.model.Recruiter;

public interface JobRepository extends JpaRepository<Job,Integer > {

	List<Job> findByRecruiter(Recruiter recruiter);

	List<Job> findByRecruiterOrderByPostDateAsc(Recruiter recruiter);

	List<Job> findAllByOrderByIdDesc();

}
