package com.uce.edu.demo.tarea23.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.ProyectoU2AmApplication;
import com.uce.edu.demo.tarea23.repository.modelo.Consola;

@Repository
@Transactional
public class ConsolaRepositoryImpl implements IConsolaRepository {

	private static final Logger LOG = Logger.getLogger(ConsolaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Consola c) {
		// TODO Auto-generated method stub
		LOG.info("Insertando Consola: " + c);
		this.entityManager.persist(c);
	}

	@Override
	public void actualizar(Consola c) {
		// TODO Auto-generated method stub
		LOG.info("Actualizando Consola: " + c);
		this.entityManager.merge(c);
	}

	@Override
	public Consola buscar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Buscando la Consola de id: " + id);
		return this.entityManager.find(Consola.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		LOG.info("Eliminando a la Consola de id: " + id);
		this.entityManager.remove(this.buscar(id));
	}

}
