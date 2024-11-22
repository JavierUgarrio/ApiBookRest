package com.company.books.backend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.dao.ICategoriaDao;
import com.company.books.backend.response.CategoriaResponseRest;



@Service
public class CategoriaServiceImpl implements ICategoriaService{

	// Registro de logs para seguimiento de eventos en la aplicación
	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImpl.class);
	
	// Inyección de dependencia para acceder al repositorio de categorías
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)// Método de solo lectura, no modifica datos
	public CategoriaResponseRest buscarCategorias() {
		// Registro de inicio
		log.info("inicio metodo buscarCategorias()");
		
		// Estructura para almacenar la respuesta final
		CategoriaResponseRest response = new CategoriaResponseRest();
		try {
			// Obtiene todas las categorías de la base de datos
			List<Categoria>categoria = (List<Categoria>) categoriaDao.findAll();
			// Asigna las categorías obtenidas al objeto de respuesta
			response.getCategoriaResponse().setCategoria(categoria);
			// Define metadatos indicando que la operación fue exitosa
			response.setMetadata("Respuesta OK","200","Respuesta Exitosa");
		}catch(Exception ex) {
			// En caso de error, asigna metadatos de fallo
			response.setMetadata("Fallo", "-1", " Respuesta incorrecta");
			// Registra el error en los logs
			log.error("error al consultar categorias: "+ ex.getMessage());
			// Detalles del error (opcional)
			ex.getStackTrace();
		}
		// Devuelve la respuesta procesada
		return response;
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

