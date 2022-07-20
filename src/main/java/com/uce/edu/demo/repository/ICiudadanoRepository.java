package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

public interface ICiudadanoRepository {

	public void crear(Ciudadano c);

	public void actualizar(Ciudadano c);

	public Ciudadano buscar(Integer id);

	public void eliminar(Integer id);

}
