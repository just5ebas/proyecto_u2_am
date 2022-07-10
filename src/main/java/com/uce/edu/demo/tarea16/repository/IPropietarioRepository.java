package com.uce.edu.demo.tarea16.repository;

import com.uce.edu.demo.tarea16.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario p);

	public void eliminar(String cedula);
	
	public Propietario consultar(String cedula);

}
