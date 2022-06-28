package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcService {

	public void guardar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(int id);

	public Persona buscar(int id);

}
