package com.uce.edu.demo.repository.modelo.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro1_autor1")
public class LibroAutor {

	@Id
	@Column(name = "liau1_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liau1_id_seq")
	@SequenceGenerator(name = "liau1_id_seq", sequenceName = "liau1_id_seq", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "liau1_id_libro")
	private Libro1 libro;

	@ManyToOne
	@JoinColumn(name = "liau1_id_autor")
	private Autor1 autor;

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Libro1 getLibro() {
		return libro;
	}

	public void setLibro(Libro1 libro) {
		this.libro = libro;
	}

	public Autor1 getAutor() {
		return autor;
	}

	public void setAutor(Autor1 autor) {
		this.autor = autor;
	}

}
