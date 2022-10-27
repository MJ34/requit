package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.Skills;
import com.pk.recruiter.repository.SkillsRepository;

@Service
@Transactional
public class SkillsService {

	@Autowired
	private SkillsRepository skillsRepo;
	public void saveAll(List<Skills> skillsList) {
		skillsRepo.saveAll(skillsList);
	}
	
	

	public List<Skills> findByJobSeeker(JobSeeker jobSeeker) {
		return skillsRepo.findByJobSeeker(jobSeeker);
		
	}

	public void deleteAll(List<Skills> findByJobSeeker) {
		skillsRepo.deleteAll(findByJobSeeker);
		
	}
}
