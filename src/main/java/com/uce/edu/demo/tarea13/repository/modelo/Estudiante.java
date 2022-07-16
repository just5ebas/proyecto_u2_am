package com.uce.edu.demo.tarea13.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@NamedQuery(name = "Estudiante.buscarPorApellido", query = "SELECT e FROM Estudiante e WHERE e.apellido = :dato_apellido ORDER BY e.apellido")
@NamedQuery(name = "Estudiante.buscarPorNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :dato_nombre ORDER BY e.nombre")
@NamedQuery(name = "Estudiante.buscarPorSemestre", query = "SELECT e FROM Estudiante e WHERE e.semestre = :dato_semestre1 OR e.semestre = :dato_semestre2 ORDER BY e.semestre")
@NamedQuery(name = "Estudiante.buscarPorEdad", query = "SELECT e FROM Estudiante e WHERE e.edad BETWEEN :dato_edad1 AND :dato_edad2 ORDER BY e.edad")
@NamedNativeQuery(name = "Estudiante.buscarPorCedulaNative", query = "SELECT * FROM estudiante WHERE estu_cedula = :dato_cedula", resultClass = Estudiante.class)
@NamedNativeQuery(name = "Estudiante.buscarPorSemestreNative", query = "SELECT * FROM estudiante WHERE estu_semestre = :dato1_semestre OR estu_semestre = :dato2_semestre", resultClass = Estudiante.class)
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_id_seq")
	@SequenceGenerator(name = "estu_id_seq", sequenceName = "estu_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Column(name = "estu_edad")
	private Integer edad;

	@Column(name = "estu_genero")
	private String genero;

	@Column(name = "estu_semestre")
	private String semestre;

	@Column(name = "estu_carrera")
	private String carrera;

	public Estudiante() {
	}

	public Estudiante(Integer id, String cedula, String nombre, String apellido, Integer edad, String semestre,
			String carrera) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.semestre = semestre;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", semestre=" + semestre + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
