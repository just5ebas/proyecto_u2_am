package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcRepository {

	public Persona buscarPorId(int id);

	public void insertar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(int cedula);

}
