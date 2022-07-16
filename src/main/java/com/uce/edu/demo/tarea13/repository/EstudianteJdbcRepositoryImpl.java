package com.uce.edu.demo.tarea13.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {

	private static final Logger LOG = Logger.getLogger(EstudianteJdbcRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertar(Estudiante e) {
		LOG.info("Insertando en la base de datos: " + e);
		this.jdbcTemplate.update(
				"INSERT INTO estudiante(estu_cedula, estu_nombre, estu_apellido, estu_edad, estu_semestre, estu_carrera) VALUES (?, ?, ?, ?, ?, ?)",
				new Object[] { e.getCedula(), e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre(),
						e.getCarrera() });
		LOG.info("Se inserto el estudiante a la base de datos.");
	}

	@Override
	public void actualizar(Estudiante e) {
		LOG.info("Actualizando en la base de datos al estudiante de id: " + e.getId());
		this.jdbcTemplate.update(
				"UPDATE estudiante SET estu_nombre=?, estu_apellido=?, estu_edad=?, estu_semestre=?, estu_carrera=? WHERE estu_id=?",
				new Object[] { e.getNombre(), e.getApellido(), e.getEdad(), e.getSemestre(), e.getCarrera(),
						e.getCedula() });
		LOG.info("Se actualizo la informacion del estudiante en la base de datos.");
	}

	@Override
	public Estudiante buscar(Integer id) {
		LOG.info("Buscando en la base de datos al estudiante de id: " + id);
		return this.jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE estu_id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void eliminar(Integer id) {
		LOG.info("Eliminando de la base de datos al estudiante de id: " + id);
		this.jdbcTemplate.update("DELETE FROM estudiante WHERE estu_id=?", new Object[] { id });
		LOG.info("Se elimino al estudiante de la base de datos.");
	}

}
