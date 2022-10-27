package com.pk.recruiter.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pk.recruiter.model.Application;
import com.pk.recruiter.model.Job;
import com.pk.recruiter.repository.ApplicationRepository;
import com.pk.recruiter.repository.JobRepository;


@CrossOrigin(origins = {"http://localhost:4200","http://localHost:8080"})
@RestController
@RequestMapping("/api/application")
public class ApplicationRestController {

	@Autowired
	private JobRepository jobRepo;

	
	@PostMapping("/applicantDetails")
	public List<Application> applicantDetails(@RequestBody Map<String,String> jobId) {
		System.out.println("Application Called");
		Integer id=Integer.parseInt(jobId.get("id"));
		Job job=jobRepo.findById(id).get();
		List<Application> applicationList=job.getApplicaionsList();
		return applicationList;
	
	}

}
