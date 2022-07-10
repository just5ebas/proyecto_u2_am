package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AmApplication;
import com.uce.edu.demo.tarea16.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static final Logger LOG = Logger.getLogger(MatriculaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crear(Matricula m) {
		LOG.info("Insertando en la base de datos: " + m);
		this.entityManager.persist(m);
	}

}
