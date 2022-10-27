package com.pk.recruiter.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hrm_users")
public class LoginUsers {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginUsers [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public LoginUsers(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginUsers() {
		super();
	}

	@Id
	private int id;
	private String email;
	private String password;
}
