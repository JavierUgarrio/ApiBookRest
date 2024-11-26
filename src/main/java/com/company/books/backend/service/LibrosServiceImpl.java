package com.company.books.backend.service;


import java.util.*;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.books.backend.model.Libro;
import com.company.books.backend.model.dao.ILibrosDao;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.response.LibrosResponseRest;



@Service
public class LibrosServiceImpl implements ILibrosService {

	//Registrar los logs de seguimiento de eventos
	private static final Logger log = LoggerFactory.getLogger(LibrosServiceImpl.class);
	
	@Autowired
	private ILibrosDao librosDao;
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<LibrosResponseRest>buscarLibros() {
		log.info("inicio del metodo buscarLibros()");
		LibrosResponseRest response = new LibrosResponseRest();
		try {
			List<Libro> libros =(List<Libro>) librosDao.findAll();
			response.getLibrosResponse().setLibros(libros);
			response.setMetadata("Respuesta OK", "200", "Respuesta Exitosa");
		}catch(Exception ex) {
			response.setMetadata("Fallo", "-1", "Respuesta incorrecta");
			log.error("error a la hora de consultar libros: "+ex.getMessage());
			ex.getStackTrace();
			return new ResponseEntity<LibrosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		return new ResponseEntity<LibrosResponseRest>(response,HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<LibrosResponseRest>buscarLibrosId(Long id){
		log.info("inicio del metodo buscarLibrosId()");
		LibrosResponseRest response = new LibrosResponseRest();
		List<Libro>listaLibros = new ArrayList<>();
		try {
			Optional<Libro> libros = librosDao.findById(id);
			if(libros.isPresent()) {
				listaLibros.add(libros.get());
				response.getLibrosResponse().setLibros(listaLibros);
			}else {
				log.error("error en la consulta Libros");
				response.setMetadata("Fallo en la consulta", "-1", "Respuesta incorrecta");
				return new ResponseEntity<LibrosResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			
		}catch(Exception ex){
			response.setMetadata("Fallo", "-1", "Respuesta incorrecta");
			log.error("error a la hora de consultar libros por Id: "+ex.getMessage());
			ex.getStackTrace();
			return new ResponseEntity<LibrosResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setMetadata("Respuesta OK", "200", "Respuesta Exitosa");
		return new ResponseEntity<LibrosResponseRest>(response, HttpStatus.OK);
	}

}
