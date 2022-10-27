package com.pk.recruiter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Certifications;
import com.pk.recruiter.model.JobSeeker;

public interface CertificationsRepository extends JpaRepository<Certifications, Integer> {

	List<Certifications> findByJobSeeker(JobSeeker activeUser);

	Certifications findByUrl(String url);

}
