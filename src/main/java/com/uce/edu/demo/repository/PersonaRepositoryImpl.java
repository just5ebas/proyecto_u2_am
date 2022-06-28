package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.Persona;

@Repository
public class PersonaRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Persona buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public void insertar(Persona p) {
		this.jdbcTemplate.update("INSERT INTO persona(id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { p.getId(), p.getNombre(), p.getApellido() });
	}

	@Override
	public void actualizar(Persona p) {
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { p.getNombre(), p.getApellido(), p.getId() });
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { id });
	}

}
