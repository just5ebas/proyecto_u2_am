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
	public void eliminar(Integer id) {
		LOG.info("Eliminando al propietario de cedula: " + id);
		this.entityManager.remove(this.consultar(id));
	}

	@Override
	public Propietario consultar(Integer id) {
		LOG.info("Buscando al propietario de cedula: " + id);
		return this.entityManager.find(Propietario.class, id);
	}

}
