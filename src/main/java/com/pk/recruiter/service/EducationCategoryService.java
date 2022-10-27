package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.EducationCategory;
import com.pk.recruiter.repository.EducationCategoryRepository;

@Service
@Transactional
public class EducationCategoryService {

	@Autowired
	private EducationCategoryRepository educationCategoryRepo;

	public List<EducationCategory> saveAll(List<EducationCategory> educationCategoryList) {
		return educationCategoryRepo.saveAll(educationCategoryList);
	}

	public EducationCategory findByEducationCategoryName(String educationCategoryName) {
		return educationCategoryRepo.findByEducationCategoryName(educationCategoryName).get();
	}

	public List<EducationCategory> findAll() {
		return educationCategoryRepo.findAll();
	}

	public List<EducationCategory> findAllByOrderByidAsc() {
		return educationCategoryRepo.findAllByOrderByIdAsc();
	}

}
