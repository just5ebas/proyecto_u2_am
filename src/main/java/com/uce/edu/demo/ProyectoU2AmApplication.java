package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Insertar
		Persona p1 = new Persona();
		p1.setId(2);
		p1.setNombre("Nicolas");
		p1.setApellido("Nashe");
//		this.iPersonaJdbcService.guardar(p1);

		// Actualizar
		Persona p2 = new Persona();
		p2.setId(3);
		p2.setNombre("A");
		p2.setApellido("B");
//		this.iPersonaJdbcService.actualizar(p2);

		// Eliminar
//		this.iPersonaJdbcService.eliminar(3);

		// Buscar
		Persona p = this.iPersonaJdbcService.buscar(1);
		LOG.info(p);

	}

}
