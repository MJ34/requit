package com.pk.recruiter.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.Job;
import com.pk.recruiter.repository.JobRepository;

@Service
@Transactional
public class JobService {

	@Autowired(required=true)
	private JobRepository jobRepo;
	
	
	public List<Job> getJobList() {
	
		return jobRepo.findAllByOrderByIdDesc();
	}


	public List<Job> saveAll(List<Job> jobListDb) {
	return jobRepo.saveAll(jobListDb);
		
	}


	public  Optional<Job> findById(int theJobId) {
		return jobRepo.findById(theJobId);
	}

	

}
