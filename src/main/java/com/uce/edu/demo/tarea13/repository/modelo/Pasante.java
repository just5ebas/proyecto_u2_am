package com.uce.edu.demo.tarea13.repository.modelo;

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
@Table(name = "pasante")
public class Pasante {

	@Id
	@Column(name = "psnt_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "psnt_id_seq")
	@SequenceGenerator(name = "psnt_id_seq", sequenceName = "psnt_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "psnt_horas_por_cumplir")
	private Integer horasPorCumplir;

	@Column(name = "psnt_horas_cumplidas")
	private Integer horasCumplidas;

	@Column(name = "psnt_nombre_empresa")
	private String nombreEmpresa;

	@Column(name = "psnt_recibe_pago")
	private Boolean recibePago;

	@OneToOne
	@JoinColumn(name = "psnt_id_estudiante")
	private Estudiante estudiante;

	// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHorasPorCumplir() {
		return horasPorCumplir;
	}

	public void setHorasPorCumplir(Integer horasPorCumplir) {
		this.horasPorCumplir = horasPorCumplir;
	}

	public Integer getHorasCumplidas() {
		return horasCumplidas;
	}

	public void setHorasCumplidas(Integer horasCumplidas) {
		this.horasCumplidas = horasCumplidas;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Boolean getRecibePago() {
		return recibePago;
	}

	public void setRecibePago(Boolean recibePago) {
		this.recibePago = recibePago;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
