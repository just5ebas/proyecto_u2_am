package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AmApplication;
import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	private static final Logger LOG = Logger.getLogger(VehiculoRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo v) {
		LOG.info("Creando vehiculo: " + v);
		this.entityManager.persist(v);
	}

	@Override
	public void actualizar(Vehiculo v) {
		LOG.info("Actualizando vehiculo: " + v);
		this.entityManager.merge(v);
	}

	@Override
	public void eliminar(String placa) {
		LOG.info("Eliminando al vehiculo de placa: " + placa);
		this.entityManager.remove(this.buscar(placa));
	}

	@Override
	public Vehiculo buscar(String placa) {
		LOG.info("Buscando al vehiculo de placa: " + placa);
		return this.entityManager.find(Vehiculo.class, placa);
	}

}
