package com.uce.edu.demo.tarea13.service;

import com.uce.edu.demo.tarea13.repository.to.Estudiante;

public interface IEstudianteJpaService {

	public void crear(Estudiante e);

	public void renovarInformacion(Estudiante e);

	public Estudiante consultar(String cedula);

	public void eliminarRegistro(String cedula);

}
