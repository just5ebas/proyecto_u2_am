package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJdbcRepository;
import com.uce.edu.demo.to.Persona;

@Service
public class PersonaServiceImpl implements IPersonaJdbcService {

	@Autowired
	private IPersonaJdbcRepository iPersonaJdbcRepository;

	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.iPersonaJdbcRepository.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.iPersonaJdbcRepository.actualizar(p);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.iPersonaJdbcRepository.eliminar(id);
	}

	@Override
	public Persona buscar(int id) {
		// TODO Auto-generated method stub
		return this.iPersonaJdbcRepository.buscarPorId(id);
	}

}
