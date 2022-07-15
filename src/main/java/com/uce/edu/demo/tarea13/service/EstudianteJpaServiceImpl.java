package com.uce.edu.demo.tarea13.service;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.Persona;
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

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarTodos();
	}

	@Override
	public List<Estudiante> buscarTodosOrdenados() {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarTodosOrdenados();
	}

	@Override
	public List<Estudiante> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombre(nombre);
	}

	@Override
	public List<Estudiante> buscarPorSemestre(String semestre1, String semestre2) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorSemestre(semestre1, semestre2);
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad1, Integer edad2) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorEdad(edad1, edad2);
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		return this.estudianteJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorSemestreNative(String semestre1, String semestre2) {
		return this.estudianteJpaRepository.buscarPorSemestreNative(semestre1, semestre2);
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		return this.estudianteJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public List<Estudiante> buscarPorSemestreNamedNative(String semestre1, String semestre2) {
		return this.estudianteJpaRepository.buscarPorSemestreNamedNative(semestre1, semestre2);
	}

}
