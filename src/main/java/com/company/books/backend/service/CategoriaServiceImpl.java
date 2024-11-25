package com.company.books.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.dao.ICategoriaDao;
import com.company.books.backend.response.CategoriaResponseRest;



@Service
//Marca la clase como un servicio en Spring, indicando que esta clase contiene la lógica de negocio.
public class CategoriaServiceImpl implements ICategoriaService {

 // Registro de logs para hacer seguimiento de los eventos en la aplicación (para depuración y auditoría).
 private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
 
 // Inyección de dependencia de ICategoriaDao, que es el repositorio de las categorías.
 // Esto permite acceder a la base de datos sin necesidad de inicializar manualmente el objeto.
 @Autowired
 private ICategoriaDao categoriaDao;

 // Implementación del método declarado en la interfaz ICategoriaService.
 @Override
 @Transactional(readOnly = true) // Indica que este método solo lee datos, no realiza cambios en la base de datos.
 public ResponseEntity<CategoriaResponseRest> buscarCategorias() {
     // Registra un mensaje en los logs indicando que el método ha comenzado a ejecutarse.
     log.info("inicio metodo buscarCategorias()");

     // Crea un objeto de respuesta, donde se almacenará la información que se enviará al cliente.
     CategoriaResponseRest response = new CategoriaResponseRest();
     
     try {
         // Intenta obtener todas las categorías de la base de datos utilizando el repositorio.
         List<Categoria> categoria = (List<Categoria>) categoriaDao.findAll();
         
         // Asigna las categorías obtenidas al objeto de respuesta.
         response.getCategoriaResponse().setCategoria(categoria);
         
         // Establece los metadatos indicando que la operación fue exitosa.
         response.setMetadata("Respuesta OK", "200", "Respuesta Exitosa");
     } catch (Exception ex) {
         // Si ocurre un error durante la consulta, establece los metadatos de fallo.
         response.setMetadata("Fallo", "-1", "Respuesta incorrecta");
         
         // Registra el error en los logs para poder hacer un seguimiento.
         log.error("error al consultar categorias: " + ex.getMessage());
         
         // Detalles adicionales del error (opcional).
         ex.getStackTrace();
         
         // Retorna una respuesta HTTP con el estado de error 500 (Internal Server Error).
         return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
     }
     
     // Si todo ha ido bien, devuelve la respuesta con un estado HTTP 200 (OK).
     return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
 }
 
 @Override
 @Transactional(readOnly = true) // Este método solo lee datos de la base de datos, no los modifica.
 public ResponseEntity<CategoriaResponseRest> buscarPorId(Long id) {

     log.info("inicio metodo buscarPorId"); // Escribe en los logs que el método ha comenzado.

     CategoriaResponseRest response = new CategoriaResponseRest(); // Crea un objeto para devolver los datos de la categoría al cliente.
     List<Categoria> list = new ArrayList<>(); // Lista para guardar la categoría encontrada.

     try {
         Optional<Categoria> categoria = categoriaDao.findById(id); // Busca una categoría en la base de datos usando el ID.

         if (categoria.isPresent()) { // Si la categoría existe:
             list.add(categoria.get()); // La añade a la lista.
             response.getCategoriaResponse().setCategoria(list); // Guarda la lista dentro del objeto de respuesta.
         } else { // Si no encuentra la categoría:
             log.error("Error en consultar la categoria"); // Escribe un error en los logs.
             response.setMetadata("Fallo en la respuesta", "-1", "Categoria no encontrada"); // Indica en los metadatos que no se encontró.
             return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND); // Devuelve un estado 404 (no encontrado).
         }

     } catch (Exception ex) { // Si ocurre un error mientras se busca la categoría:
         log.error("Error en consultar la categoria"); // Escribe un error en los logs.
         response.setMetadata("Fallo en la respuesta", "-1", "Categoria no encontrada"); // Indica que ocurrió un problema.
         return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Devuelve un estado 500 (error del servidor).
     }
  
     response.setMetadata("Respuesta OK", "200", "Respuesta Exitosa");// Establece los metadatos indicando que la operación fue exitosa.
     return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK); // Si todo fue bien, devuelve la respuesta con estado 200 (OK).
 }

 @Override
 @Transactional
 public ResponseEntity<CategoriaResponseRest>crearCategoria(Categoria categoria){
	 log.info("inicio metodo crearCategoria"); // Escribe en los logs que el método ha comenzado.
	 
	 CategoriaResponseRest response = new CategoriaResponseRest(); // Crea un objeto para devolver los datos de la categoría al cliente.
     List<Categoria> list = new ArrayList<>(); // Lista para guardar la categoría encontrada.
     
     try {
    	 Categoria categoriaGuardada = categoriaDao.save(categoria);
    	 if(categoriaGuardada !=null){
    		 list.add(categoriaGuardada);
             response.getCategoriaResponse().setCategoria(list); 
    	 }else {
    		 log.error("Error en grabar la categoria"); // Escribe un error en los logs.
             response.setMetadata("Fallo en la respuesta", "-1", "Categoria no guardada"); // Indica en los metadatos que no se encontró.
             return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST); // Devuelve un estado 404 (no encontrado).
    	 }
     }catch(Exception ex) {
    	 log.error("Error al crear la categoria Libro"); // Escribe un error en los logs.
         response.setMetadata("Fallo en la respuesta", "-1", "Categoria no insertada"); // Indica que ocurrió un problema.
         return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); // Devuelve un estado 500 (error del servidor).
     }
     response.setMetadata("Respuesta OK", "200", "Respuesta Exitosa");// Establece los metadatos indicando que la operación fue exitosa.
     return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK); // Si todo fue bien, devuelve la respuesta con estado 200 (OK).
 }
 
 
}
/*
 	Esta clase CategoriaServiceImpl implementa el método buscarCategorias, 
 	que se encarga de obtener todas las categorías almacenadas en la base de datos, procesar los datos y devolverlos en un formato organizado 
 	(usando CategoriaResponseRest). También incluye manejo de errores para casos en los que la consulta falle.

	Objetivo
	El objetivo de esta clase es ser el intermediario entre la capa de datos (ICategoriaDao) y las respuestas que se envían al cliente. 
	Además, garantiza un formato uniforme para las respuestas y centraliza la lógica del negocio relacionada con las categorías.
 */

