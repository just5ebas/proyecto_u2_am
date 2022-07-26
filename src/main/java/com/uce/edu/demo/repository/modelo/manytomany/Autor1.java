package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor1")
public class Autor1 {

	@Id
	@Column(name = "autr1_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autr1_id_seq")
	@SequenceGenerator(name = "autr1_id_seq", sequenceName = "autr1_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "autr1_nombre")
	private String nombre;

	@OneToMany(mappedBy = "autor")
	private List<LibroAutor> libroAutor;

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

	public List<LibroAutor> getLibroAutor() {
		return libroAutor;
	}

	public void setLibroAutor(List<LibroAutor> libroAutor) {
		this.libroAutor = libroAutor;
	}

}
