package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {

	public Persona buscarPorCedula(String cedula);

	public List<Persona> buscarPorApellido(String apellido);

	public List<Persona> buscarPorGenero(String genero);

	public List<Persona> buscarPorNombre(String nombre);

	public Persona buscarPorId(Integer id);

	public void insertar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

}
