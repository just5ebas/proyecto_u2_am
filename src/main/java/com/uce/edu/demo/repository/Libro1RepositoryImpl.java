package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro1;

@Repository
@Transactional
public class Libro1RepositoryImpl implements ILibro1Repository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro1 l1) {
		this.entityManager.persist(l1);
	}

	@Override
	public void actualizar(Libro1 l1) {
		this.entityManager.merge(l1);
	}

	@Override
	public Libro1 buscar(Integer id) {
		return this.entityManager.find(Libro1.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Libro1 buscarPorNombre(String nombre) {
		TypedQuery<Libro1> myQuery = this.entityManager.createQuery("SELECT l FROM Libro1 l WHERE l.titulo = :titulo",
				Libro1.class);
		myQuery.setParameter("titulo", nombre);
		return myQuery.getSingleResult();
	}

}
