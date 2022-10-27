package com.pk.recruiter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.recruiter.model.LoginUsers;
import com.pk.recruiter.repository.LoginUserRepository;

@Service
@Transactional
public class LoginUsersService {

	@Autowired 
	private LoginUserRepository loginUserRepo;
//	public LoginUsers checkUsers(LoginUsers theLoginUsers) {
//		return loginUserRepo.findByEmailAndPassword(theLoginUsers.getEmail(),theLoginUsers.getPassword());
//	}
	public LoginUsers findByEmail(String email) {
		return loginUserRepo.findByEmail(email);
	}



}
