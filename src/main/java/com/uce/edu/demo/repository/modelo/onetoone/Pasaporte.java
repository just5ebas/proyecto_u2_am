package com.uce.edu.demo.repository.modelo.onetoone;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {

	@Id
	@Column(name = "pspt_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pspt_id_seq")
	@SequenceGenerator(name = "pspt_id_seq", sequenceName = "pspt_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "pspt_numero")
	private String numero;

	@Column(name = "pspt_fec_emision")
	private LocalDateTime fechaEmision;

	@Column(name = "pspt_fec_caducidad")
	private LocalDateTime fechaCaducidad;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pspt_id_ciudadano")
	private Ciudadano ciudadano;

	@Override
	public String toString() {
		return "Pasaporte [id=" + id + ", numero=" + numero + ", fechaEmision=" + fechaEmision + ", fechaCaducidad="
				+ fechaCaducidad + ", ciudadano=" + ciudadano + "]";
	}

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

}
