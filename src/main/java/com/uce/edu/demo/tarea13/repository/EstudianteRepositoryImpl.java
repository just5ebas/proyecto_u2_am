package com.uce.edu.demo.tarea13.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.to.Estudiante;

@Repository
public class EstudianteRepositoryImpl implements IEstudianteJdbcRepository {

	private static final Logger LOG = Logger.getLogger(EstudianteRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertar(Estudiante e) {
		LOG.info("Insertando en la base de datos: " + e);
		this.jdbcTemplate.update(
				"INSERT INTO estudiante(cedula, nombre, apellido, edad, semestre) VALUES (?, ?, ?, ?, ?)",
				new Object[] { e.getCedula(), e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre() });
		LOG.info("Se inserto el estudiante a la base de datos.");
	}

	@Override
	public void actualizar(Estudiante e) {
		LOG.info("Actualizando en la base de datos al estudiante de cedula: " + e.getCedula());
		this.jdbcTemplate.update("UPDATE estudiante SET nombre=?, apellido=?, edad=?, semestre=? WHERE cedula=?",
				new Object[] { e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre(), e.getCedula() });
		LOG.info("Se actualizo la informacion del estudiante en la base de datos.");
	}

	@Override
	public Estudiante buscar(String cedula) {
		LOG.info("Buscando en la base de datos al estudiante de cedula: " + cedula);
		return this.jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE cedula = ?", new Object[] { cedula },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void eliminar(String cedula) {
		LOG.info("Eliminando de la base de datos al estudiante de cedula: " + cedula);
		this.jdbcTemplate.update("DELETE FROM estudiante WHERE cedula=?", new Object[] { cedula });
		LOG.info("Se elimino al estudiante de la base de datos.");
	}

}
