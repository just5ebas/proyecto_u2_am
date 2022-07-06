package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaService {

	public void guardar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

	public Persona buscar(Integer id);

	public Persona buscarXCedula(String cedula);
	
	public List<Persona> buscarXApellido(String apellido);
	
	public List<Persona> buscarXGenero(String genero);

}
