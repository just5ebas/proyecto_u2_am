package com.uce.edu.demo.tarea13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea13.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {

	@Autowired
	private IEstudianteJdbcRepository estudianteJdbcRepository;

	@Override
	public void crear(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.insertar(e);
	}

	@Override
	public void renovarInformacion(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.actualizar(e);
	}

	@Override
	public Estudiante consultar(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteJdbcRepository.buscar(id);
	}

	@Override
	public void eliminarRegistro(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteJdbcRepository.eliminar(id);
	}

}
