package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		LOG.info(this.iPersonaJdbcService.buscarTodos());

		// Buscar
//		LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscar(2));

		// Insertar
		Persona p = new Persona();
		p.setId(6);
		p.setNombre("Edison");
		p.setApellido("Cayambe");

//		this.iPersonaJpaService.guardar(p);

		// Actualizar
		Persona p1 = new Persona();
		p1.setId(2);
		p1.setNombre("Javier");
		p1.setApellido("Diaz");
//		this.iPersonaJpaService.actualizar(p1);

		// Eliminar
		this.iPersonaJpaService.eliminar(6);

	}

}
