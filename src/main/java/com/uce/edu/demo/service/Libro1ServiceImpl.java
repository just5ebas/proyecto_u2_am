package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibro1Repository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro1;

@Service
public class Libro1ServiceImpl implements ILibro1Service {

	@Autowired
	private ILibro1Repository libro1Repository;

	@Override
	public void insertar(Libro1 l1) {
		this.libro1Repository.insertar(l1);
	}

	@Override
	public void actualizar(Libro1 l1) {
		this.libro1Repository.actualizar(l1);
	}

	@Override
	public Libro1 buscar(Integer id) {
		return this.libro1Repository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.libro1Repository.eliminar(id);
	}

	@Override
	public Libro1 buscarPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return this.libro1Repository.buscarPorNombre(titulo);
	}

}
