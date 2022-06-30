package com.uce.edu.demo.tarea13.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.repository.to.Estudiante;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {

	private final static Logger LOG = Logger.getLogger(EstudianteJpaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante e) {
		LOG.info("Insertando en la base de datos: " + e);
		this.entityManager.persist(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		LOG.info("Actualizando en la base de datos: " + e);
		this.entityManager.merge(e);
	}

	@Override
	public Estudiante buscar(String cedula) {
		LOG.info("Buscando en la base de datos al estudiante con cedula: " + cedula);
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public void eliminar(String cedula) {
		LOG.info("Eliminando de la base de datos al estudiante de cedula: " + cedula);
		this.entityManager.remove(this.buscar(cedula));
	}

}
