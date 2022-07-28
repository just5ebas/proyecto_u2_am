package com.uce.edu.demo.tarea16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea16.repository.IPropietarioRepository;
import com.uce.edu.demo.tarea16.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void crear(Propietario p) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.crear(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iPropietarioRepository.eliminar(id);
	}

}
