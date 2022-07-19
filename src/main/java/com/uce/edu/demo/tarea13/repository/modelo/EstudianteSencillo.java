package com.uce.edu.demo.tarea13.repository.modelo;

import java.io.Serializable;

public class EstudianteSencillo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String genero;

	public EstudianteSencillo() {
	}

	public EstudianteSencillo(String nombre, String apellido, String genero) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "EstudianteSencillo [nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero + "]";
	}

	// GET & SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
