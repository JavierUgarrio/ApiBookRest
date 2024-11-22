package com.company.books.backend.service;

import com.company.books.backend.response.CategoriaResponseRest;

public interface ICategoriaService {

	public CategoriaResponseRest buscarCategorias();
	
}
/*
	La interfaz ICategoriaService sirve para definir un método llamado buscarCategorias, que cualquier clase debe implementar si quiere manejar las categorías del sistema.

	Esto ayuda a mantener el código organizado, ya que asegura que todas las clases que trabajen con categorías sigan las mismas reglas
 	y puedan devolver datos de categorías en un formato estándar, como CategoriaResponseRest.

*/