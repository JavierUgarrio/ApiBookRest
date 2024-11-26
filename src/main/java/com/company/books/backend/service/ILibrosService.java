package com.company.books.backend.service;

import org.springframework.http.ResponseEntity;

import com.company.books.backend.response.LibrosResponseRest;

public interface ILibrosService {

	public ResponseEntity<LibrosResponseRest> buscarLibros();
	public ResponseEntity<LibrosResponseRest>buscarLibrosId(Long id);
}
