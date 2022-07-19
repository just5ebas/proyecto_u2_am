package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {

	@Autowired
	private IPersonaJpaRepository iPersonaJpaRepository;

	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorId(id);
	}

	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.actualizar(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPersonaJpaRepository.eliminar(id);
	}

	@Override
	public Persona buscarXCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public Persona buscarXCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarXCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarXCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	@Override
	public Persona buscarXCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public Persona buscarXCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		return this.iPersonaJpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}

	@Override
	public List<Persona> buscarXApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<PersonaSencilla> buscarXApellidoSencillo(String apellido) {
		return this.iPersonaJpaRepository.buscarPorApellidoSencillo(apellido);
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadXGenero() {
		return this.iPersonaJpaRepository.consultarCantidadPorGenero();
	}

	@Override
	public List<Persona> buscarXNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public List<Persona> buscarXGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarXNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.iPersonaJpaRepository.eliminarPorGenero(genero);
	}

}
