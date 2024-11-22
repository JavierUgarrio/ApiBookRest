package com.company.books.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.service.ICategoriaService;

@RestController // Marca esta clase como un controlador REST para manejar solicitudes HTTP
@RequestMapping("/v1") // Define la ruta base de este controlador como /v1
public class CategoriaRestController {
	
	@Autowired // Inyección de dependencia para usar el servicio sin inicializarlo manualmente
	private ICategoriaService service;// Servicio para manejar la lógica de negocio de categorías
	
	@GetMapping("/categorias")// Define que este método responderá a solicitudes GET en /v1/categorias
	public CategoriaResponseRest consultaCat() {
		// Llama al servicio para obtener las categorías de la base de datos
		CategoriaResponseRest response = service.buscarCategorias();
		// Devuelve la respuesta al cliente en formato JSON
		return response;
	}
}
/*
	@RestController
	- Indica que esta clase es un controlador REST.
	- Su objetivo es gestionar solicitudes HTTP (como GET, POST, etc.) y devolver respuestas directamente en formato JSON o similar.
	
	@RequestMapping("/v1")
	- Define la ruta base de este controlador como /v1.
	- Todas las rutas dentro de esta clase tendrán esta base, como por ejemplo /v1/categorias
	
	@Autowired
	- Inyecta automáticamente una instancia de ICategoriaService para usar su funcionalidad.
	- Permite acceder a los métodos del servicio sin necesidad de inicializarlo manualmente.
	
	private ICategoriaService service;
	- Declara una variable que representa el servicio que contiene la lógica de negocio de categorías.
	
	@GetMapping("/categorias")
	- Define que este método responderá a solicitudes HTTP GET en la ruta /v1/categorias.
	- Su objetivo es ofrecer una forma de consultar las categorías.
	
	public CategoriaResponseRest consultaCat()
	- Declara un método que devuelve una respuesta del tipo CategoriaResponseRest, que contiene la información de las categorías.
	
	CategoriaResponseRest response = service.buscarCategorias();
	- Llama al servicio para obtener la lista de categorías desde la base de datos.
	- La respuesta se almacena en la variable response.
	
	return response;
	- Devuelve la respuesta obtenida al cliente en formato JSON.
*/