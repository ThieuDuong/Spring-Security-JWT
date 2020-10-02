package com.thieuduong.springsecurityjwt.models;

public class AdminAuthenticationResponse {
	private final String adminToken;
	
	public AdminAuthenticationResponse(String adminToken) {
		this.adminToken = adminToken;
	}
	
	public String getToken() {
		return adminToken;
	}
}
