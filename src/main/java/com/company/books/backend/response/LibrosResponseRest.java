package com.company.books.backend.response;

public class LibrosResponseRest extends ResponseRest{

	private LibrosResponse librosResponse = new LibrosResponse();
	
	//Get & Set
	
	public LibrosResponse getLibrosResponse() {
		return librosResponse;
	}

	public void setLibrosResponse(LibrosResponse librosResponse) {
		this.librosResponse = librosResponse;
	}
}
