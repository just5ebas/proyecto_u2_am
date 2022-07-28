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
	public void eliminar(Integer id) {
		LOG.info("Eliminando al vehiculo de id: " + id);
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Vehiculo buscar(Integer id) {
		LOG.info("Buscando al vehiculo de id: " + id);
		return this.entityManager.find(Vehiculo.class, id);
	}

}
