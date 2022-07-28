package com.uce.edu.demo.tarea16.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea16.repository.IVehiculoRepository;
import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public void insertar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.insertar(v);
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.actualizar(v);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iVehiculoRepository.eliminar(id);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepository.buscar(id);
	}

}
