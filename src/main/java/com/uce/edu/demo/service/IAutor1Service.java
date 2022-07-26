package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.manytomany.Autor1;

public interface IAutor1Service {

	public void insertar(Autor1 a1);

	public void actualizar(Autor1 a1);

	public Autor1 buscar(Integer id);

	public void eliminar(Integer id);

	public Autor1 buscarPorNombre(String nombre);

}
