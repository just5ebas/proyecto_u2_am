package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;

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
	public Persona buscarPorCedulaTyped(String cedula) {
		TypedQuery<Persona> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Persona p WHERE p.cedula = :dato_cedula", Persona.class);
		myTypedQuery.setParameter("dato_cedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("dato_cedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("dato_cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :dato_cedula",
				Persona.class);
		myQuery.setParameter("dato_cedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative",
				Persona.class);
		myQuery.setParameter("dato_cedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// Creamos una instancia de la interfaz CriteriaBuilder - Fábrica para construir
		// el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		// Especificamos el retorno de nuestra consulta
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		// Aqui empieza la construccion del SQL
		// Root FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class); // FROM persona
//		myQuery.select(personaFrom); // SELECT FROM persona
		// Las condiciones en Criteria API se las conoce como predicados
		Predicate p1 = myBuilder.equal(personaFrom.get("cedula"), cedula); // p.cedula = :dato_cedula

		// forma 1:
//		CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaFrom).where(p1);
//		// Finalizado mi query completo
//
//		TypedQuery<Persona> myFinalQuery = this.entityManager.createQuery(myQueryCompleto);

		// forma 2:
		myQuery.select(personaFrom).where(p1); // myQuery ya guarda los cambios del select y del where
		// Finalizado mi query completo

		TypedQuery<Persona> myFinalQuery = this.entityManager.createQuery(myQuery);

		return myFinalQuery.getSingleResult();
	}

	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		Root<Persona> myTable = myQuery.from(Persona.class);

		// pers_nombre = 'Manuel'
		Predicate predicadoNombre = myBuilder.equal(myTable.get("nombre"), nombre);

		// pers_apellido = 'Pele'
		Predicate predicadoApellido = myBuilder.equal(myTable.get("apellido"), apellido);

		Predicate predicadoGenero = myBuilder.equal(myTable.get("genero"), genero);

		Predicate miPredicadoFinal = null;
		if (genero.equalsIgnoreCase("M")) {
			// pers_apellido = 'Pele' AND pers_nombre = 'Manuel'
			miPredicadoFinal = myBuilder.and(predicadoNombre, predicadoApellido);
		} else {
			// pers_apellido = 'Pele' OR pers_nombre = 'Manuel'
			miPredicadoFinal = myBuilder.or(predicadoNombre, predicadoApellido);
		}

		myQuery.select(myTable).where(miPredicadoFinal);

		TypedQuery<Persona> queryFinal = this.entityManager.createQuery(myQuery);

		return queryFinal.getSingleResult();
	}

	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);

		Root<Persona> myTable = myQuery.from(Persona.class);

		Predicate predicadoNombre = myBuilder.equal(myTable.get("nombre"), nombre);
		Predicate predicadoApellido = myBuilder.equal(myTable.get("apellido"), apellido);
		Predicate predicadoGenero = myBuilder.equal(myTable.get("genero"), genero);

		Predicate miPredicadoFinal = null;
		if (genero.equalsIgnoreCase("M")) {
			// pers_genero = 'M' AND pers_apellido = 'Pele' AND pers_nombre = 'Manuel'
			miPredicadoFinal = myBuilder.and(predicadoNombre, predicadoApellido, predicadoGenero);
		} else {
			// pers_genero = 'F' AND (pers_nombre = 'Daniela' OR pers_apellido = 'Aroja')
			miPredicadoFinal = myBuilder.or(predicadoNombre, predicadoApellido);
			miPredicadoFinal = myBuilder.and(miPredicadoFinal, predicadoGenero);
		}

		myQuery.select(myTable).where(miPredicadoFinal);

		TypedQuery<Persona> queryFinal = this.entityManager.createQuery(myQuery);

		return queryFinal.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// SELECT * FROM persona WHERE pers_apellido = _;
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :apellido");
		myQuery.setParameter("apellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<PersonaSencilla> buscarPorApellidoSencillo(String apellido) {
		// SELECT pers_nombre FROM persona WHERE pers_apellido = _;
		TypedQuery<PersonaSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSencilla(p.nombre, p.apellido) FROM Persona p WHERE p.apellido = :dato_apellido",
				PersonaSencilla.class);
		myQuery.setParameter("dato_apellido", apellido);

		return myQuery.getResultList();
	}

	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// SELECT pers_genero, COUNT(pers_genero) FROM persona GROUP BY pers_genero
		// SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero,
		// COUNT(p.genero)) FROM Persona p GROUP BY p.genero
		TypedQuery<PersonaContadorGenero> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, COUNT(p.genero)) FROM Persona p GROUP BY p.genero",
				PersonaContadorGenero.class);

		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",
				Persona.class);
		myQuery.setParameter("dato_nombre", nombre);
		myQuery.setParameter("dato_apellido", apellido);
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
		Query myQuery = this.entityManager
				.createQuery("UPDATE Persona p SET p.genero = :genero WHERE p.apellido = :apellido");
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
