package com.company.books.backend.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;


@Entity
@Table(name="libros")
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6992684974740872661L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Categoria categoria;
	
	
	/*
	 	@ManyToOne(fetch = FetchType.LAZY)
	  	Indica que esta entidad tiene una relación de "muchos a uno" con otra entidad (en este caso, "Categoria"). 
		Esto significa que muchas instancias de esta entidad pueden estar asociadas a una única categoría.
		El atributo "fetch = FetchType.LAZY" especifica que los datos de la categoría no se cargarán automáticamente al cargar esta entidad.
		En lugar de eso, se cargarán solo cuando se necesiten, mejorando el rendimiento.
		
		@JsonIgnoreProperties({"hibermateLazyInitializer", "handler"})
		Esta anotación evita que ciertas propiedades internas de Hibernate, como "hibernateLazyInitializer" y "handler", 
		aparezcan en el JSON generado cuando esta entidad se convierte a JSON. 
		Esto es útil para prevenir errores de serialización y simplificar la respuesta JSON.
	 */
	
	
	//Get &  Set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	 
}
