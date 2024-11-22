package com.company.books.backend.response;

public class CategoriaResponseRest extends ResponseRest {

	private CategoriaResponse  categoriaResponse = new CategoriaResponse();
	
	//Get & Set
	
	public CategoriaResponse getCategoriaResponse() {
		return categoriaResponse;
	}

	public void setCategoriaResponse(CategoriaResponse categoriaResponse) {
		this.categoriaResponse = categoriaResponse;
	}
	
}

/*
	El objetivo de la clase CategoriaResponseRest es extender la funcionalidad de ResponseRest para incluir una respuesta específica relacionada con las categorías, organizando los datos de las categorías dentro de un contenedor llamado CategoriaResponse.

	Propósito:
	Especialización de respuesta: Combina la información general de una respuesta (definida en ResponseRest, como metadatos) con un contenido específico (la lista de categorías, manejada por CategoriaResponse).
	Facilitar la estructuración de datos: Proporciona un formato completo y organizado para las respuestas de API que incluyen tanto los datos de categorías como información adicional sobre la respuesta (metadatos, estado, etc.).
	
	Detalles:
	CategoriaResponseRest extends ResponseRest:
		- Hereda la funcionalidad de ResponseRest, como los metadatos (tipo, código, fecha).
		- Agrega un atributo propio específico para manejar las categorías.
	
	Atributo categoriaResponse:
		- Es un objeto de tipo CategoriaResponse, que encapsula la lista de categorías.
		- Permite centralizar los datos relacionados con las categorías dentro de esta clase.
	
	Métodos getter y setter:
		- getCategoriaResponse(): Devuelve el objeto CategoriaResponse.
		- setCategoriaResponse(CategoriaResponse categoriaResponse): Permite establecer o actualizar el objeto de tipo CategoriaResponse.
	
	Ejemplo práctico:
	Si una API devuelve una respuesta completa con información de categorías y metadatos, podría estructurarse así:
		
		json
		Copiar código
		{
		  "metadata": [
		    { "tipo": "info", "codigo": "200", "dato": "2024-11-22" }
		  ],
		  "categoriaResponse": {
		    "categoria": [
		      { "id": 1, "nombre": "Ficción", "descripcion": "Libros de ficción" },
		      { "id": 2, "nombre": "Historia", "descripcion": "Libros históricos" }
		    ]
		  }
		}
		
	Resumen:
	La clase CategoriaResponseRest organiza las respuestas de API relacionadas con las categorías, combinando:
	
	Los metadatos de la respuesta (heredados de ResponseRest).
	Los datos específicos de las categorías (manejado por CategoriaResponse).
	Esto permite mantener un diseño limpio y reutilizable, ideal para sistemas con respuestas estructuradas.
 
 */
