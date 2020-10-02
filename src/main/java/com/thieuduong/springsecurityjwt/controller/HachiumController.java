package com.thieuduong.springsecurityjwt.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thieuduong.springsecurityjwt.models.AdminAuthenticationResponse;
import com.thieuduong.springsecurityjwt.models.AuthenticationRequest;
import com.thieuduong.springsecurityjwt.service.MyUserDetailsService;
import com.thieuduong.springsecurityjwt.util.JwtUtil;

@RestController
public class HachiumController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDertailsService;

	@Autowired
	private JwtUtil jwtUtil;

	String token = "token";
	String status = "status";
	String message = "message";
	String username = "hachium";
	String password = "3thangdev";

	@PostMapping("/developers.hachium.com/app/sign_in")
	public Map<String, String> signInToHachium(@RequestBody AuthenticationRequest authenticationRequest) throws UnsupportedEncodingException {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("email: " + authenticationRequest.getEmail());
		//email = URLEncoder.encode(email, StandardCharsets.UTF_8.toString());
		//System.out.println("after encode: " + email);
		if (authenticationRequest.getEmail().equals(username) && password.equals(password)) {
			final UserDetails userDetails = myUserDertailsService.loadUserByUsername(username);
			final String studentToken = jwtUtil.generateToken(userDetails);
			map.put(status, "200");
			map.put(token, studentToken);
		} else {
			map.put(status, "003");
			map.put(message, "Username or Password is incorrect");
		}
		return map;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken() throws Exception {
		final UserDetails userDetails = myUserDertailsService.loadUserByUsername("admin");
		final String adminToken = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AdminAuthenticationResponse(adminToken));
	}
}
