package com.company.books.backend.response;

import java.util.*;

import com.company.books.backend.model.Libro;

public class LibrosResponse {

	private List<Libro> libros;
	
	//Get & Set
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
