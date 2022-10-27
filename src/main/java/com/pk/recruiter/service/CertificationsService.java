package com.pk.recruiter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.Certifications;
import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.repository.CertificationsRepository;


@Service
@Transactional
public class CertificationsService {
	
	@Autowired
	private CertificationsRepository certRepo;

	public List<Certifications> findByJobSeeker(JobSeeker activeUser) {
		return certRepo.findByJobSeeker(activeUser);

	}

	public void deleteById(Integer id) {
		certRepo.deleteById(id);
	}

	public Certifications findByUrl(String url) {
		return certRepo.findByUrl(url);
	}

	

}
