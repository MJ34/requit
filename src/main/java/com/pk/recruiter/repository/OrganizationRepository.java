package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    
    List<Organization> findByJobSeeker(JobSeeker activeUser);

    Organization findByName(String name);
}
