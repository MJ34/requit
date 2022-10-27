package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.Family;
import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.repository.FamilyRepository;

@Service
@Transactional
public class FamilyService {

    @Autowired
    private FamilyRepository famRepo;

    public List<Family> findByJobSeeker(JobSeeker activeUser) {
		return famRepo.findByJobSeeker(activeUser);

	}

	public void deleteById(Integer id) {
		famRepo.deleteById(id);
	}

	public Family findByIdCard(String idCard) {
		return famRepo.findByIdCard(idCard);
	}

    
}
