package com.pk.recruiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.recruiter.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer> {

	public Users findByEmail(String email);

	public Users findByEmailAndPassword(String email, String password);
}
