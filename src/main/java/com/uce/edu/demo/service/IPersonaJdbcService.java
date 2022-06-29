package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.to.PersonaTO;

public interface IPersonaJdbcService {

	public void guardar(PersonaTO p);

	public void actualizar(PersonaTO p);

	public void eliminar(int id);

	public PersonaTO buscar(int id);
	
	public List<PersonaTO> buscarTodos();

}
