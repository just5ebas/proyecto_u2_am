package com.uce.edu.demo;

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

		// BUSCAR POR CEDULA NATIVE
		Persona p1 = this.iPersonaJpaService.buscarXCedulaNative("1750844787");

		LOG.info("Resultado búsqueda Native: " + p1);

		// BUSCAR POR CEDULA NAMED NATIVE
		Persona p2 = this.iPersonaJpaService.buscarXCedulaNamedNative("1011121315");

		LOG.info("Resultado búsqueda Named Native: " + p2);

	}

}
