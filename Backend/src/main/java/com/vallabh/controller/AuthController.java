package com.vallabh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vallabh.config.JwtProvider;
import com.vallabh.models.User;
import com.vallabh.repository.UserRepository;
import com.vallabh.request.LoginRequest;
import com.vallabh.response.AuthResponse;
import com.vallabh.service.CustomUserDetailService;
import com.vallabh.service.UserService;




@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CustomUserDetailService customUserDetails;
	
	@PostMapping("/signup")
	public AuthResponse createUser(@RequestBody User user) throws Exception {
		
		
		User isExist = userRepository.findByEmail(user.getEmail());
		
		if(isExist!=null) {
			throw new Exception("Email already used..");
		}
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser = userRepository.save(newUser);

		
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(), savedUser.getPassword());
		
		
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Register Success");
		
		return res;	
	}
	
	@PostMapping("/signin")
	public AuthResponse signin(@RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticate (loginRequest.getEmail(),loginRequest.getPassword());
		String token = JwtProvider.generateToken(authentication);
		
		AuthResponse res = new AuthResponse(token,"Login Success");
		
		return res;	
	}


	private Authentication authenticate(String email, String password) {
		UserDetails userDetails = customUserDetails.loadUserByUsername(email);
		
		if(userDetails == null) {
			throw new BadCredentialsException("Invalid Username");
		}
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			
			throw new BadCredentialsException("Wrong Password"+userDetails.getPassword()+" "+password);
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	}
	
}
