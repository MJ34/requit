package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.Education;
import com.pk.recruiter.model.EducationCategory;
import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.repository.EducationRepo;

@Service
@Transactional
public class EducationService {

	@Autowired
	private EducationRepo educationRepo;
	public Education save(Education education)
	{
		return educationRepo.save(education);
	}
	public List<Education> findByJobSeeker(JobSeeker activeUser) {
		return educationRepo.findByJobSeeker(activeUser);
	}
	public List<Education> findByJobSeekerOrderByEducationCategoryAsc(JobSeeker activeUser) {
		return educationRepo.findByJobSeekerOrderByEducationCategoryAsc(activeUser);
	}
	

	public void deleteById(int educationId) {
		 educationRepo.deleteById(educationId);
	}
	public Education findByEducationCategoryAndJobSeeker(EducationCategory educationCategory, JobSeeker activeUser) {
		return educationRepo.findByEducationCategoryAndJobSeeker(educationCategory,activeUser);
	}
}
