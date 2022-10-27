package com.pk.recruiter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.JobSeeker;
import com.pk.recruiter.model.Users;
import com.pk.recruiter.repository.UsersRepository;


@Service
@Transactional
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;
	
	public Users findByEmail(String email) {
		return usersRepo.findByEmail(email);
	}

	public JobSeeker findByJobSeeker(JobSeeker jobseeker) {
		return null;
	}

}
