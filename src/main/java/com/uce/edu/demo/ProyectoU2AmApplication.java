package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IPersonaJpaService iPersonaJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Insertar Persona
		Persona p1 = new Persona();
		p1.setNombre("Andrea");
		p1.setApellido("Mañas");
		p1.setCedula("1516145112");
		p1.setGenero("F");

//		this.iPersonaJpaService.guardar(p1);

		// 1. TypedQuery
		Persona pTyped = this.iPersonaJpaService.buscarXCedulaTyped(p1.getCedula());
		LOG.info("Persona Typed: " + pTyped);

		// 2. NamedQuery
		Persona pNamed = this.iPersonaJpaService.buscarXCedulaNamed(p1.getCedula());
		LOG.info("Persona Named: " + pNamed);

		// 3. TypedQuery y NamedQuery
		Persona pTypedNamed = this.iPersonaJpaService.buscarXCedulaTypedNamed(p1.getCedula());
		LOG.info("Persona TypedNamed: " + pTypedNamed);

		// 4. Varios NamedQuery
		List<Persona> lista = this.iPersonaJpaService.buscarXNombreApellido("Andrea", "Mañas");

		for (Persona item : lista) {
			LOG.info("Persona: " + item);
		}

	}

}
