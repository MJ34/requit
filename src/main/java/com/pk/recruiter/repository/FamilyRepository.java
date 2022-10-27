package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.recruiter.model.Family;
import com.pk.recruiter.model.JobSeeker;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {

    List<Family> findByJobSeeker(JobSeeker activeUser);

    Family findByIdCard(String idCard);
}
