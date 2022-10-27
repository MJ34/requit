package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.WorkExperience;

@Repository
public interface WorkExpRepository extends JpaRepository<WorkExperience, Integer> {
    
    List<WorkExperience> findByJobSeeker(JobSeeker activeUser);

    WorkExperience findByName(String name);
}
