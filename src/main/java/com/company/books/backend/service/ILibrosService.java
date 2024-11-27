package com.company.books.backend.service;

import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Libro;
import com.company.books.backend.response.LibrosResponseRest;

public interface ILibrosService {

	public ResponseEntity<LibrosResponseRest> buscarLibros();
	public ResponseEntity<LibrosResponseRest>buscarLibrosId(Long id);
	public ResponseEntity<LibrosResponseRest>crearLibro(Libro libro);
	public ResponseEntity<LibrosResponseRest>editarLibro(Libro libro, Long id);
	public ResponseEntity<LibrosResponseRest>eliminarLibro(Long id);
}
