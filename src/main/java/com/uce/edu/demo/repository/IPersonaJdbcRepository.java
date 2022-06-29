package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.to.PersonaTO;

public interface IPersonaJdbcRepository {
	
	public List<PersonaTO> buscarTodos();
	
	public PersonaTO buscarPorId(int id);

	public void insertar(PersonaTO p);

	public void actualizar(PersonaTO p);

	public void eliminar(int id);

}
