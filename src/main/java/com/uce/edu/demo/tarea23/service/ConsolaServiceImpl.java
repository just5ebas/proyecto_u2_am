package com.uce.edu.demo.tarea23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea23.repository.IConsolaRepository;
import com.uce.edu.demo.tarea23.repository.modelo.Consola;

@Service
public class ConsolaServiceImpl implements IConsolaService {

	@Autowired
	private IConsolaRepository iConsolaRepository;

	@Override
	public void insertar(Consola c) {
		// TODO Auto-generated method stub
		this.iConsolaRepository.insertar(c);
	}

	@Override
	public void actualizar(Consola c) {
		// TODO Auto-generated method stub
		this.iConsolaRepository.actualizar(c);
	}

	@Override
	public Consola buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iConsolaRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iConsolaRepository.eliminar(id);
	}

}
