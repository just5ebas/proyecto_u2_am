package com.uce.edu.demo.tarea16.repository;

import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;

public interface IVehiculoRepository {

	public void insertar(Vehiculo v);

	public void actualizar(Vehiculo v);

	public void eliminar(Integer id);

	public Vehiculo buscar(Integer id);

}
