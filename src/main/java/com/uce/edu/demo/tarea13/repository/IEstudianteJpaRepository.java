package com.uce.edu.demo.tarea13.repository;

import java.util.List;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {

	public void insertar(Estudiante e);

	public void actualizar(Estudiante e);

	public Estudiante buscar(Integer id);

	public void eliminar(Integer id);

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

}
