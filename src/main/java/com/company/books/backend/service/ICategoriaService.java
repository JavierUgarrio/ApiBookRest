package com.company.books.backend.service;

import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	// Declara un método para buscar categorías en el sistema.
    // Este método devuelve un ResponseEntity que contiene un objeto CategoriaResponseRest,
    // el cual incluye la información de las categorías y metadatos de la operación.
	public ResponseEntity<CategoriaResponseRest> buscarCategorias();
	
	
	public ResponseEntity<CategoriaResponseRest>buscarPorId(Long id);
	
	public ResponseEntity<CategoriaResponseRest>crearCategoria(Categoria categoria);
	
	public ResponseEntity<CategoriaResponseRest>editarCategoria(Categoria categoria, Long id);
	
	public ResponseEntity<CategoriaResponseRest>eliminarCategoria(Long id);
	
}
/*
	La interfaz ICategoriaService sirve para definir un método llamado buscarCategorias, que cualquier clase debe implementar si quiere manejar las categorías del sistema.

	Esto ayuda a mantener el código organizado, ya que asegura que todas las clases que trabajen con categorías sigan las mismas reglas
 	y puedan devolver datos de categorías en un formato estándar, como CategoriaResponseRest.

*/