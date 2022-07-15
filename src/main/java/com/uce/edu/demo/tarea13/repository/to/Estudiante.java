package com.uce.edu.demo.tarea13.repository.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :dato_apellido ORDER BY e.apellido")
@NamedQuery(name = "Estudiante.buscarPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :dato_nombre ORDER BY e.nombre")
@NamedQuery(name = "Estudiante.buscarPorSemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :dato_semestre1 OR e.semestre = :dato_semestre2 ORDER BY e.semestre")
@NamedQuery(name = "Estudiante.buscarPorEdad", query = "SELECT e FROM Estudiante e WHERE e.edad BETWEEN :dato_edad1 AND :dato_edad2 ORDER BY e.edad")
@NamedNativeQuery(name = "Estudiante.buscarPorCedulaNative", query = "SELECT * FROM estudiante WHERE cedula = :dato_cedula", resultClass = Estudiante.class)
@NamedNativeQuery(name = "Estudiante.buscarPorSemestreNative", query = "SELECT * FROM estudiante WHERE semestre = :dato1_semestre OR semestre = :dato2_semestre", resultClass = Estudiante.class)
public class Estudiante {

	@Id
	@Column(name = "cedula")
	private String cedula;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "semestre")
	private String semestre;

	public Estudiante() {
	}

	public Estudiante(String cedula, String nombre, String apellido, Integer edad, String semestre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", semestre=" + semestre + "]";
	}

	// GET & SET
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
