package com.company.books.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.response.LibrosResponseRest;
import com.company.books.backend.service.ILibrosService;

@RestController
@RequestMapping("/v2")
public class LibrosRestController {

	@Autowired
	private ILibrosService service;
	
	@GetMapping("/libros")
	public ResponseEntity<LibrosResponseRest> buscarLibros(){
		return service.buscarLibros();
	}
	
	@GetMapping("/libros/{id}")
	public ResponseEntity<LibrosResponseRest>buscarLibrosId(@PathVariable Long id){
		ResponseEntity<LibrosResponseRest> response = service.buscarLibrosId(id);
		return response;
	}
}
