package com.anodiam.LoginRESTAPI.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.anodiam.LoginRESTAPI.payload.response.JwtResponse;
import com.anodiam.LoginRESTAPI.repository.Role.RoleRepository;
import com.anodiam.LoginRESTAPI.repository.User.GeneralEncoderDecoder;
import com.anodiam.LoginRESTAPI.repository.User.UserRepository;
import com.anodiam.LoginRESTAPI.security.jwt.JwtUtils;
import com.anodiam.LoginRESTAPI.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anodiam.LoginRESTAPI.payload.request.LoginRequest;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
			throws InvalidKeySpecException, NoSuchAlgorithmException {
		System.out.println("Inside Sign In");
		String userName="",email="";
		try {
			userName = new GeneralEncoderDecoder().encrypt(loginRequest.getUsername());
		}catch(Exception ex){}
		System.out.println(userName);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userName, loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		try {
			userName = new GeneralEncoderDecoder().decrypt(userDetails.getUsername());
			email = new GeneralEncoderDecoder().decrypt(userDetails.getEmail());
		}catch(Exception ex){}
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(),
												 userName, email, roles));
	}

}
