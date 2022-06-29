package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public Persona buscarPorId(Integer id);

	public void insertar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

}
