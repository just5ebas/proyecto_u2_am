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
@Table(name = "libro1")
public class Libro1 {

	@Id
	@Column(name = "libr1_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr1_id_seq")
	@SequenceGenerator(name = "libr1_id_seq", sequenceName = "libr1_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "libr1_titulo")
	private String titulo;

	@Column(name = "libr1_cantidad_paginas")
	private Integer cantidadPaginas;

	@OneToMany(mappedBy = "libro")
	private List<LibroAutor> libroAutor;

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", cantidadPaginas=" + cantidadPaginas + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public List<LibroAutor> getLibroAutor() {
		return libroAutor;
	}

	public void setLibroAutor(List<LibroAutor> libroAutor) {
		this.libroAutor = libroAutor;
	}

}