package com.uce.edu.demo.tarea16.repository;

import com.uce.edu.demo.tarea16.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void crear(Propietario p);

	public void eliminar(Integer id);
	
	public Propietario consultar(Integer id);

}
