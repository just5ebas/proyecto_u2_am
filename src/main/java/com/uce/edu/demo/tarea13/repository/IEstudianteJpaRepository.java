package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.repository.to.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante e);

	public void actualizar(Estudiante e);

	public Estudiante buscar(String cedula);

	public void eliminar(String cedula);

}
