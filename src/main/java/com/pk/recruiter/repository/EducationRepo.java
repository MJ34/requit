package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Education;
import com.pk.recruiter.model.EducationCategory;
import com.pk.recruiter.model.JobSeeker;

public interface EducationRepo extends JpaRepository<Education, Integer> {

	List<Education> findByJobSeeker(JobSeeker activeUser);

	List<Education> findByJobSeekerOrderByEducationCategoryAsc(JobSeeker activeUser);

	Education findByEducationCategoryAndJobSeeker(EducationCategory educationCategory, JobSeeker activeUser);

}
