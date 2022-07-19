package com.uce.edu.demo.tarea13.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorCarrera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String carrera;

	private Long numero;

	public EstudianteContadorCarrera() {
	}

	public EstudianteContadorCarrera(String carrera, Long numero) {
		this.carrera = carrera;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "EstudianteContadorCarrera [carrera=" + carrera + ", numero=" + numero + "]";
	}

	// GET & SET
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

}
