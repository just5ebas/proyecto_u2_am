package com.uce.edu.demo.tarea23.service;

import com.uce.edu.demo.tarea23.repository.modelo.Consola;

public interface IConsolaService {
	
	public void insertar(Consola c);

	public void actualizar(Consola c);

	public Consola buscar(Integer id);

	public void eliminar(Integer id);
	
}
