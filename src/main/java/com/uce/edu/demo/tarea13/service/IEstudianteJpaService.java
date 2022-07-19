package com.uce.edu.demo.tarea13.service;

import java.util.List;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo;

public interface IEstudianteJpaService {

	public void crear(Estudiante e);

	public void renovarInformacion(Estudiante e);

	public Estudiante consultar(Integer id);

	public void eliminarRegistro(Integer id);

	public List<Estudiante> buscarTodos();

	public List<Estudiante> buscarTodosOrdenados();

	public List<Estudiante> buscarPorApellido(String apellido);

	public List<Estudiante> buscarPorNombre(String nombre);

	public List<Estudiante> buscarPorSemestre(String semestre1, String semestre2);

	public List<Estudiante> buscarPorEdad(Integer edad1, Integer edad2);

	public Estudiante buscarPorCedulaNative(String cedula);

	public List<Estudiante> buscarPorSemestreNative(String semestre1, String semestre2);

	public Estudiante buscarPorCedulaNamedNative(String cedula);

	public List<Estudiante> buscarPorSemestreNamedNative(String semestre1, String semestre2);

	public List<Estudiante> busquedaDinamica1(String carrera, String genero);

	public List<Estudiante> busquedaDinamica2(Integer edad1, Integer edad2, String semestre);

	public List<EstudianteContadorCarrera> buscarCantidadPorCarrera(String carrera);
	
	public List<EstudianteSencillo> buscarPorApellidoSencillo(String apellido);
}
