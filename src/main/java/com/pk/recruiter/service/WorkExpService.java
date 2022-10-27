package com.pk.recruiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.WorkExperience;
import com.pk.recruiter.repository.WorkExpRepository;

@Service
public class WorkExpService {
    
    @Autowired
    private WorkExpRepository workRepo;

    public List<WorkExperience> findByJobSeeker(JobSeeker activeUser) {
		return workRepo.findByJobSeeker(activeUser);

	}

	public void deleteById(Integer id) {
		workRepo.deleteById(id);
	}

	public WorkExperience findByName(String name) {
		return workRepo.findByName(name);
	}
}
