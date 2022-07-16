package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJdbcRepository {

	public void insertar(Estudiante e);

	public void actualizar(Estudiante e);

	public Estudiante buscar(Integer id);

	public void eliminar(Integer id);

}
