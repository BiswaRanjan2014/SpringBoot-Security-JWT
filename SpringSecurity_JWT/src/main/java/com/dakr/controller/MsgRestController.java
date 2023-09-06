package com.dakr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dakr.model.AuthenticationRequest;
import com.dakr.model.AuthenticationResponce;
import com.dakr.security1.MyUserDetailsService;
import com.dakr.util.JwtUtil;

@RestController
public class MsgRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@GetMapping({ "/msg" })
	public String firstPage() {
		return "Ranjan u r the most Unified Person";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Incorrect Username Or Password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		AuthenticationResponce responce = new AuthenticationResponce(jwt);

		return new ResponseEntity<>(responce, HttpStatus.OK);
	}

}
