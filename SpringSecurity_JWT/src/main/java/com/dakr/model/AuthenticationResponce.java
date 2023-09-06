package com.dakr.model;

import lombok.Data;

@Data
public class AuthenticationResponce {
	private String jwt;

	public AuthenticationResponce(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
