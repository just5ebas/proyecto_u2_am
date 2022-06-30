package com.uce.edu.demo.tarea13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea13.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.tarea13.repository.to.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {

	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;

	@Override
	public void crear(Estudiante e) {
		this.estudianteJpaRepository.insertar(e);
	}

	@Override
	public void renovarInformacion(Estudiante e) {
		this.estudianteJpaRepository.actualizar(e);
	}

	@Override
	public Estudiante consultar(String cedula) {
		return this.estudianteJpaRepository.buscar(cedula);
	}

	@Override
	public void eliminarRegistro(String cedula) {
		this.estudianteJpaRepository.eliminar(cedula);
	}

}
