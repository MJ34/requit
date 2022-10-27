package com.pk.recruiter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.EducationCategory;

public interface EducationCategoryRepository extends JpaRepository<EducationCategory, Integer> {

	Optional<EducationCategory> findByEducationCategoryName(String educationCategoryName);

	List<EducationCategory> findAllByOrderByIdAsc();

}
