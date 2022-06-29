package com.uce.edu.demo.to;

public class PersonaTO {

	private int id;
	private String nombre;
	private String apellido;

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	// Constructor por defecto hasta que se define cualquier otro constructor
	public PersonaTO() {

	}

	public PersonaTO(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	// GET & SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apelllido) {
		this.apellido = apelllido;
	}

}
