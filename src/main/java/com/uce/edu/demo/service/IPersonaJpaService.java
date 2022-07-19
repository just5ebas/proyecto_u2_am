package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

public interface IPersonaJpaService {

	public void guardar(Persona p);

	public void actualizar(Persona p);

	public void eliminar(Integer id);

	public Persona buscar(Integer id);

	public Persona buscarXCedula(String cedula);

	public Persona buscarXCedulaTyped(String cedula);

	public Persona buscarXCedulaNamed(String cedula);

	public Persona buscarXCedulaTypedNamed(String cedula);
	
	public Persona buscarXCedulaNative(String cedula);
	
	public Persona buscarXCedulaNamedNative(String cedula);
	
	public Persona buscarPorCedulaCriteriaApi(String cedula);
	
	public Persona buscarDinamicamente(String nombre, String apellido, String genero);

	public List<Persona> buscarXApellido(String apellido);
	
	public List<PersonaSencilla> buscarXApellidoSencillo(String apellido);
	
	public List<PersonaContadorGenero> consultarCantidadXGenero();
	
	public List<Persona> buscarXNombreApellido(String nombre, String apellido);

	public List<Persona> buscarXGenero(String genero);

	public List<Persona> buscarXNombre(String nombre);

	public int actualizarPorApellido(String genero, String apellido);

	public int eliminarPorGenero(String genero);

}
