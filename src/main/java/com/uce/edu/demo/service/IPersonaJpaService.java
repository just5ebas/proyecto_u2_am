package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

	public Persona buscar(Integer id);

}
