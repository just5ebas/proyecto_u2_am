package com.uce.edu.demo.tarea23.repository.modelo;

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
@Table(name = "gamer")
public class Gamer {

	@Id
	@Column(name = "gamr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gamr_id_seq")
	@SequenceGenerator(name = "gamr_id_seq", sequenceName = "gamr_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "gamr_tag")
	private String gamertag;

	@Column(name = "gamr_nombre")
	private String nombre;

	@Column(name = "gamr_apellido")
	private String apellido;

	@Column(name = "gamr_pais")
	private String pais;

	@Column(name = "gamr_edad")
	private Integer edad;

	@OneToMany(mappedBy = "gamer")
	private List<Consola> consolas;

	@Override
	public String toString() {
		return "Gamer [id=" + id + ", gamertag=" + gamertag + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", pais=" + pais + ", edad=" + edad + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGamertag() {
		return gamertag;
	}

	public void setGamertag(String gamertag) {
		this.gamertag = gamertag;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Consola> getConsolas() {
		return consolas;
	}

	public void setConsolas(List<Consola> consolas) {
		this.consolas = consolas;
	}

}
