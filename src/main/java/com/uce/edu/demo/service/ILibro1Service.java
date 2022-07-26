package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.manytomany.Libro1;

public interface ILibro1Service {

	public void insertar(Libro1 l1);

	public void actualizar(Libro1 l1);

	public Libro1 buscar(Integer id);

	public void eliminar(Integer id);

	public Libro1 buscarPorTitulo(String titulo);

}
