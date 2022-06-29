package com.uce.edu.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.rsocket.RSocketRequesterAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.PersonaTO;

@Repository
public class PersonaJdbcRepositoryImpl implements IPersonaJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public PersonaTO buscarPorId(int id) {
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id = ?", new Object[] { id },
				new BeanPropertyRowMapper<PersonaTO>(PersonaTO.class));
	}

	@Override
	public void insertar(PersonaTO p) {
		this.jdbcTemplate.update("INSERT INTO persona(id, nombre, apellido) VALUES (?, ?, ?)",
				new Object[] { p.getId(), p.getNombre(), p.getApellido() });
	}

	@Override
	public void actualizar(PersonaTO p) {
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?",
				new Object[] { p.getNombre(), p.getApellido(), p.getId() });
	}

	@Override
	public void eliminar(int id) {
		this.jdbcTemplate.update("DELETE FROM persona WHERE id=?", new Object[] { id });
	}

	@Override
	public List<PersonaTO> buscarTodos() {
		return this.jdbcTemplate.query("SELECT * FROM persona", new PersonaRowMapper());
	}

	class PersonaRowMapper implements RowMapper<PersonaTO> {

		@Override
		public PersonaTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			PersonaTO p = new PersonaTO();
			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido(rs.getString("apellido"));
			return p;
		}

	}

}
