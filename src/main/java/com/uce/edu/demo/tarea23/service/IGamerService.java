package com.uce.edu.demo.tarea23.service;

import com.uce.edu.demo.tarea23.repository.modelo.Gamer;

public interface IGamerService {

	public void insertar(Gamer g);

	public void actualizar(Gamer g);

	public Gamer buscar(Integer id);

	public void eliminar(Integer id);

}
