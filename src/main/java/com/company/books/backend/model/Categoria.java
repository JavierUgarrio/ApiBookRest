package com.company.books.backend.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity// Marca la clase como una entidad de JPA, lo que significa que estará mapeada a una tabla en la base de datos.
@Table(name="categorias")// Especifica el nombre de la tabla en la base de datos asociada con esta entidad.
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2164553723990982332L;// Identificador único para la versión serializada de la clase..Ayuda a guardar y recuperar objetos correctamente.
	
	@Id // Marca el campo como la clave primaria de la tabla.
	@GeneratedValue(strategy = GenerationType.IDENTITY)// Indica que el valor del ID será generado automáticamente por la base de datos (auto incremento)
	private Long id;
	
	private String nombre;
	private String descripcion;
	
	//Get & Set
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
	
	
}
