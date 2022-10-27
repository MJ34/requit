
package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.Application;
import com.pk.recruiter.model.Job;
import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {

	@Autowired
	private ApplicationRepository repo;
	public Application saveApplication(Application app) {
		return repo.save(app);
	}

	public List<Application> findByJobSeekerAndJob(JobSeeker jobSeeker, Job job) {
		return repo.findByJobSeekerAndJob(jobSeeker,job);
	}

	public List<Application> findByJobSeeker(JobSeeker jobSeeker) {
		return repo.findByJobSeeker(jobSeeker);
	}

	public List<Application> findByJobSeekerAndJobAndStatus(JobSeeker jobSeeker, Job job, boolean b) {
		return repo.findByJobSeekerAndJobAndStatus(jobSeeker,job,b);
	}

	public List<Application> findByJobSeekerAndStatus(JobSeeker jobSeeker, boolean b) {
		return repo.findByJobSeekerAndStatus(jobSeeker, b);
	}

	

	public void deleteApplication(Application application) {
		 repo.deleteById(application.getId()); 
	}




}
