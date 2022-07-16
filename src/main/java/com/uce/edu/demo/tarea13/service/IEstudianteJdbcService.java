package com.uce.edu.demo.tarea13.service;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJdbcService {
	
	public void crear(Estudiante e);
	
	public void renovarInformacion(Estudiante e);
	
	public Estudiante consultar(Integer id);
	
	public void eliminarRegistro(Integer id);
	
}
