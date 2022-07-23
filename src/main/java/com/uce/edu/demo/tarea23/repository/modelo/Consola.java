package com.uce.edu.demo.tarea23.repository.modelo;

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
@Table(name = "consola")
public class Consola {

	@Id
	@Column(name = "cnsl_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cnsl_id_seq")
	@SequenceGenerator(name = "cnsl_id_seq", sequenceName = "cnsl_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "cnsl_num_serie")
	private String numSerie;

	@Column(name = "cnsl_plataforma")
	private String plataforma;

	@Column(name = "cnsl_num_juegos")
	private Integer numJuegos;

	@ManyToOne
	@JoinColumn(name = "cnsl_id_gamer")
	private Gamer gamer;

	@Override
	public String toString() {
		return "Consola [id=" + id + ", numSerie=" + numSerie + ", plataforma=" + plataforma + ", numJuegos="
				+ numJuegos + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Integer getNumJuegos() {
		return numJuegos;
	}

	public void setNumJuegos(Integer numJuegos) {
		this.numJuegos = numJuegos;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

}
