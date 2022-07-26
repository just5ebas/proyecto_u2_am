package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.LibroAutor;

@Repository
@Transactional
public class LibroAutorRepositoryImpl implements ILibroAutorRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(LibroAutor libro_autor) {
		this.entityManager.persist(libro_autor);
	}

}
