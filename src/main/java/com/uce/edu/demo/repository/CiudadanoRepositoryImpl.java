package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AmApplication;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {

	private static final Logger LOG = Logger.getLogger(CiudadanoRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Ciudadano c) {
		// TODO Auto-generated method stub
		LOG.info("Ciudadano insertado: " + c);
		this.entityManager.persist(c);
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		LOG.info("Ciudadano actualizado: " + c);
		this.entityManager.merge(c);
	}

	@Override
	public Ciudadano buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Buscando ciudadano de id: " + id);
		return this.entityManager.find(Ciudadano.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Eliminando al ciudadano de id: " + id);
		this.entityManager.remove(this.buscar(id));
	}

}
