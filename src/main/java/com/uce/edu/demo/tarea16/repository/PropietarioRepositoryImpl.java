package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AmApplication;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea16.repository.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	private static final Logger LOG = Logger.getLogger(PropietarioRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Propietario p) {
		LOG.info("Creando al propietario: " + p);
		this.entityManager.persist(p);
	}

	@Override
	public void eliminar(String cedula) {
		LOG.info("Eliminando al propietario de cedula: " + cedula);
		this.entityManager.remove(this.consultar(cedula));
	}

	@Override
	public Propietario consultar(String cedula) {
		LOG.info("Buscando al propietario de cedula: " + cedula);
		return this.entityManager.find(Propietario.class, cedula);
	}

}
