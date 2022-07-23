package com.uce.edu.demo.tarea23.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea23.repository.modelo.Gamer;

@Repository
@Transactional
public class GamerRepositoryImpl implements IGamerRepository {
	
	private static final Logger LOG = Logger.getLogger(GamerRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Gamer g) {
		// TODO Auto-generated method stub
		LOG.info("Insertando Gamer: " + g);
		this.entityManager.persist(g);
	}

	@Override
	public void actualizar(Gamer g) {
		// TODO Auto-generated method stub
		LOG.info("Actualizando al Gamer: " + g);
		this.entityManager.merge(g);
	}

	@Override
	public Gamer buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Buscando al Gamer de id: " + id);
		return this.entityManager.find(Gamer.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Eliminado al Gamer de id: " + id);
		this.entityManager.remove(this.buscar(id));
	}

}
