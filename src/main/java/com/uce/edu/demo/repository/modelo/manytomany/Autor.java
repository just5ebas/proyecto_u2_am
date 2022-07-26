package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@Column(name = "autr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autr_id_seq")
	@SequenceGenerator(name = "autr_id_seq", sequenceName = "autr_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "autr_nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "autores")
	private Set<Libro> libros;

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

}
