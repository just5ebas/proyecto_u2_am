package com.uce.edu.demo.tarea13.repository;

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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo;

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
	public Estudiante buscar(Integer id) {
		LOG.info("Buscando en la base de datos al estudiante con id: " + id);
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		LOG.info("Eliminando de la base de datos al estudiante de id: " + id);
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Estudiante> buscarTodos() {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarTodosOrdenados() {
		TypedQuery<Estudiante> myQuery = this.entityManager
				.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido", Estudiante.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorApellido(String apellido) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido");
		myQuery.setParameter("dato_apellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorNombre(String nombre) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombre");
		myQuery.setParameter("dato_nombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorSemestre(String semestre1, String semestre2) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestre",
				Estudiante.class);
		myQuery.setParameter("dato_semestre1", semestre1);
		myQuery.setParameter("dato_semestre2", semestre2);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> buscarPorEdad(Integer edad1, Integer edad2) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorEdad",
				Estudiante.class);
		myQuery.setParameter("dato_edad1", edad1);
		myQuery.setParameter("dato_edad2", edad2);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE cedula = :dato_cedula",
				Estudiante.class);
		myQuery.setParameter("dato_cedula", cedula);
		return (Estudiante) myQuery.getSingleResult();

	}

	@Override
	public List<Estudiante> buscarPorSemestreNative(String semestre1, String semestre2) {
		Query myQuery = this.entityManager.createNativeQuery(
				"SELECT * FROM estudiante WHERE semestre = :dato1_semestre OR semestre = :dato2_semestre",
				Estudiante.class);
		myQuery.setParameter("dato1_semestre", semestre1);
		myQuery.setParameter("dato2_semestre", semestre2);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaNative", Estudiante.class);
		myQuery.setParameter("dato_cedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorSemestreNamedNative(String semestre1, String semestre2) {
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorSemestreNative", Estudiante.class);
		myQuery.setParameter("dato1_semestre", semestre1);
		myQuery.setParameter("dato2_semestre", semestre2);
		return myQuery.getResultList();
	}

	@Override
	public List<Estudiante> busquedaDinamica1(String carrera, String genero) {
		// Buscar a los estudiantes por su genero, si son hombres mostrar unicamente los
		// que pertenezcan a la carrera mencionada. Si son mujeres, no se hara ninguna
		// comparacion, y se devolveran todas las mujeres.

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		Root<Estudiante> estudianteFrom = myQuery.from(Estudiante.class);

		Predicate predicadoGenero = myBuilder.equal(estudianteFrom.get("genero"), genero);
		Predicate predicadoCarrera = myBuilder.equal(estudianteFrom.get("carrera"), carrera);

		Predicate predicadoFinal = null;
		if (genero.equalsIgnoreCase("M")) {
			predicadoFinal = myBuilder.and(predicadoGenero, predicadoCarrera);
		} else {
			predicadoFinal = predicadoGenero;
		}

		myQuery.select(estudianteFrom).where(predicadoFinal);

		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(myQuery);

		return queryFinal.getResultList();
	}

	@Override
	public List<Estudiante> busquedaDinamica2(Integer edad1, Integer edad2, String semestre) {
		// Este metodo buscara a los estudiantes de cuarto semestre. Si no son parte de
		// ese semestre, entonces buscara a los estudiantes dentro del rango de edad.

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Estudiante> myQuery = myBuilder.createQuery(Estudiante.class);

		Root<Estudiante> estudianteFrom = myQuery.from(Estudiante.class);

		Predicate predicadoEdad = myBuilder.between(estudianteFrom.get("edad"), edad1, edad2);
		Predicate predicadoSemestre = myBuilder.equal(estudianteFrom.get("semestre"), semestre);

		Predicate predicadoFinal = null;
		if (semestre.equalsIgnoreCase("Cuarto")) {
			predicadoFinal = predicadoSemestre;
		} else {
			predicadoFinal = predicadoEdad;
		}

		myQuery.select(estudianteFrom).where(predicadoFinal);

		TypedQuery<Estudiante> queryFinal = this.entityManager.createQuery(myQuery);

		return queryFinal.getResultList();
	}

	public List<EstudianteContadorCarrera> buscarCantidadPorCarrera(String carrera) {
		// SELECT estu_carrera, COUNT(estu_carrera) FROM estudiante GROUP BY
		// estu_carrera
		// SELECT NEW
		// com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera
		// (e.carrera, COUNT(e.carrera)) FROM Estudiante e GROUP BY e.carrera
		TypedQuery<EstudianteContadorCarrera> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera(e.carrera, COUNT(e.carrera)) FROM Estudiante e GROUP BY e.carrera",
				EstudianteContadorCarrera.class);

		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteSencillo> buscarPorApellidoSencillo(String apellido) {
		// SELECT estu_nombre, estu_apellido, estu_genero FROM estudiante WHERE
		// estu_apellido LIKE ?
		// SELECT NEW
		// com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo(e.nombre,
		// e.apellido, e.genero) FROM Estudiante e WHERE e.apellido LIKE :dato_apellido
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo(e.nombre, e.apellido, e.genero) FROM Estudiante e WHERE e.apellido LIKE :dato_apellido",
				EstudianteSencillo.class);
		apellido = apellido + "%";
		myQuery.setParameter("dato_apellido", apellido);
		return myQuery.getResultList();
	}

}
