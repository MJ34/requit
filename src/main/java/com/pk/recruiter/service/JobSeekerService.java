package com.pk.recruiter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.repository.JobSeekerRepository;

@Service
@Transactional
public class JobSeekerService {

	@Autowired
	private JobSeekerRepository repo;

	public void saveJobSeeker(JobSeeker theJobSeeker) {
		repo.save(theJobSeeker);
	}

	public JobSeeker findById(Integer activeUser) {
		return repo.findById(activeUser).get();
	}

}
