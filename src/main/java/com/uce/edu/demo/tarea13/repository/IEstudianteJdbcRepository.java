package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.to.Estudiante;

public interface IEstudianteJdbcRepository {

	public void insertar(Estudiante e);

	public void actualizar(Estudiante e);

	public Estudiante buscar(String cedula);

	public void eliminar(String cedula);

}
