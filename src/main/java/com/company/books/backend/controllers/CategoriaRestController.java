package com.company.books.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.service.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController // Marca esta clase como un controlador REST para manejar solicitudes HTTP
@RequestMapping("/v1") // Define la ruta base de este controlador como /v1
public class CategoriaRestController { 
    // Clase que actúa como un controlador REST para manejar solicitudes HTTP relacionadas con categorías.

    @Autowired 
    // Inyección de dependencia: Spring inicializa automáticamente el objeto 'service' 
    // para que podamos usarlo sin crear una instancia manualmente.
    private ICategoriaService service; 
    // Servicio que contiene la lógica de negocio para gestionar las categorías.
    
    //GET
    @GetMapping("/categorias") 
    // Define que este método manejará solicitudes HTTP GET en el endpoint /v1/categorias.
    public ResponseEntity<CategoriaResponseRest> consultaCat() {
        // Llama al servicio para obtener las categorías desde la base de datos y devolver la respuesta.
        return service.buscarCategorias(); 
        // Devuelve un objeto ResponseEntity con la lista de categorías y el estado HTTP correspondiente.
    }
    
    //GET
    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest>consultaCategoriasId(@PathVariable Long id){
    	ResponseEntity<CategoriaResponseRest> response = service.buscarPorId(id);
    	return response;
    }
    
    //POST	
    @PostMapping("/categorias")
    public ResponseEntity<CategoriaResponseRest>crearCaTegoria(@RequestBody Categoria request){
    	ResponseEntity<CategoriaResponseRest> response = service.crearCategoria(request);
    	return response;
    }
    
    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest>editarCategoria(@RequestBody Categoria reques,@PathVariable Long id ){
    	ResponseEntity<CategoriaResponseRest> response = service.editarCategoria(reques, id);
    	return response;
    }
    
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<CategoriaResponseRest>eliminarCategoria(@PathVariable Long id){
    	ResponseEntity<CategoriaResponseRest>response = service.eliminarCategoria(id);
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