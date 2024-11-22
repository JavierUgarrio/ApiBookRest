package com.company.books.backend.response;

import java.util.*;

import com.company.books.backend.model.Categoria;

public class CategoriaResponse {

	private List<Categoria> categoria;

	//get & set
	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	
}
/*
	El objetivo de la clase CategoriaResponse es encapsular una lista de objetos de tipo Categoria para ser utilizada como parte de la respuesta en una API o aplicación.

	Propósito:
		Organizar datos: Esta clase sirve como un contenedor para devolver una lista de categorías cuando se solicitan múltiples registros desde el sistema.
		
		Estandarización: Permite manejar las respuestas de manera uniforme, facilitando la interacción con otras partes de la aplicación o el cliente que consume la API.
	
	Detalles:
		Atributo categoria: Es una lista de objetos Categoria, que representa un conjunto de categorías.
		Métodos getter y setter:
			getCategoria(): Permite obtener la lista de categorías almacenadas.
			setCategoria(List<Categoria> categoria): Permite establecer o actualizar la lista de categorías.
			
	Ejemplo práctico:
		Si una API solicita todas las categorías disponibles en el sistema, esta clase podría ser utilizada para devolver una respuesta como:
		
		json
		Copiar código
		{
		  "categoria": [
		    { "id": 1, "nombre": "Ficción", "descripcion": "Libros de ficción" },
		    { "id": 2, "nombre": "Ciencia", "descripcion": "Libros de ciencia" }
		  ]
		}
	
	En resumen, CategoriaResponse centraliza y organiza los datos de las categorías para que puedan ser enviados como parte de una respuesta en una API, ayudando a mantener una estructura clara y reutilizable. 
 */
