package com.company.books.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.model.Libro;
import com.company.books.backend.response.LibrosResponseRest;
import com.company.books.backend.service.ILibrosService;

@RestController
@RequestMapping("/v1")
public class LibrosRestController {

	@Autowired
	private ILibrosService service;
	
	@GetMapping("/libros")
	public ResponseEntity<LibrosResponseRest> buscarLibros(){
		ResponseEntity<LibrosResponseRest> response = service.buscarLibros();
		return response;
	}
	
	@GetMapping("/libros/{id}")
	public ResponseEntity<LibrosResponseRest>buscarLibrosId(@PathVariable Long id){
		ResponseEntity<LibrosResponseRest> response = service.buscarLibrosId(id);
		return response;
	}
	
	@PostMapping("/libros")
	public ResponseEntity<LibrosResponseRest> crearLibro(@RequestBody Libro libro){
		ResponseEntity<LibrosResponseRest>response = service.crearLibro(libro);
		return response;
	}
}
