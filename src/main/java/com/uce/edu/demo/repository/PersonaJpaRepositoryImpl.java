package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona p) {
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(Persona p) {
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// SELECT * FROM persona WHERE pers_cedula = _;
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :dato_cedula");
		jpqlQuery.setParameter("dato_cedula", cedula);
		return (Persona) jpqlQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// SELECT * FROM persona WHERE pers_apellido = _;
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :apellido");
		myQuery.setParameter("apellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// SELECT * FROM persona WHERE pers_genero = _;
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :dato_genero");
		myQuery.setParameter("dato_genero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// SELECT * FROM persona WHERE pers_nombre = _;
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :nombre");
		myQuery.setParameter("nombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
//		UPDATE persona SET pers_genero = 'M' WHERE pers_apellido='Maldonado'
		Query myQuery = this.entityManager.createQuery("UPDATE Persona p SET p.genero = :genero WHERE p.apellido = :apellido");
		myQuery.setParameter("genero", genero);
		myQuery.setParameter("apellido", apellido);
		return myQuery.executeUpdate(); // devuelve el total de filas actualizadas
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// DELETE FROM persona WHERE pers_genero = ?
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero = :dato_genero");
		myQuery.setParameter("dato_genero", genero);
		return myQuery.executeUpdate();
	}

}
