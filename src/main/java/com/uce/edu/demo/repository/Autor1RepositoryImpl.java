package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Autor1;

@Repository
@Transactional
public class Autor1RepositoryImpl implements IAutor1Repository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor1 a1) {
		this.entityManager.persist(a1);
	}

	@Override
	public void actualizar(Autor1 a1) {
		this.entityManager.merge(a1);
	}

	@Override
	public Autor1 buscar(Integer id) {
		return this.entityManager.find(Autor1.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public Autor1 buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Autor1> myQuery = this.entityManager.createQuery("SELECT a FROM Autor1 a WHERE a.nombre = :nombre",
				Autor1.class);
		myQuery.setParameter("nombre", nombre);
		return myQuery.getSingleResult();
	}

}
