package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Ciudadano;

public interface ICiudadanoService {

	public void insertar(Ciudadano c);

	public void actualizar(Ciudadano c);

	public Ciudadano buscar(Integer id);

	public void eliminar(Integer id);

}
