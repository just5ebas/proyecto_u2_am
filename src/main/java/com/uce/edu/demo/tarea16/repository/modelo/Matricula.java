package com.uce.edu.demo.tarea16.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "matr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matr_id_seq")
	@SequenceGenerator(name = "matr_id_seq", sequenceName = "matr_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "matr_fecha")
	private LocalDateTime fechaMatricula;

	@Column(name = "matr_valor")
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(name = "matr_id_prop")
	private Propietario propietario;

	@ManyToOne
	@JoinColumn(name = "matr_id_vehi")
	private Vehiculo vehiculo;

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fechaMatricula + ", valor=" + valor + "]";
	}

	// GET & SET
	public LocalDateTime getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
