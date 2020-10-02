package com.thieuduong.springsecurityjwt.models;

public class AuthenticationRequest {
	String email;
	String password;
	String domain;

	public AuthenticationRequest() {

	}
	
	public AuthenticationRequest(String email, String password, String domain) {
		this.email = email;
		this.password = password;
		this.domain = domain;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
