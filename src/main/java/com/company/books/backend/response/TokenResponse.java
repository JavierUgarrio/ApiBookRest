package com.company.books.backend.response;

public class TokenResponse {

	private String jwtToken;

	//constructor
	public TokenResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	//get & set 
	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
}
