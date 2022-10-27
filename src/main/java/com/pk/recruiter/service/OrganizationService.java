package com.pk.recruiter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.Organization;
import com.pk.recruiter.repository.OrganizationRepository;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository orgRepo;

    public List<Organization> findByJobSeeker(JobSeeker activeUser) {
		return orgRepo.findByJobSeeker(activeUser);

	}

	public void deleteById(Integer id) {
		orgRepo.deleteById(id);
	}

	public Organization findByName(String name) {
		return orgRepo.findByName(name);
	}
    
}
