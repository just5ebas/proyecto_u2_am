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

		// BUSCAR POR CEDULA CRITERIA API
		Persona p1 = this.iPersonaJpaService.buscarPorCedulaCriteriaApi("1750844787");

		LOG.info("Resultado búsqueda Criteria API: " + p1);

		// BUSCAR POR CEDULA CRITERIA API
		Persona perDinamica = this.iPersonaJpaService.buscarDinamicamente("Manuel", "Pele", "M");

		LOG.info("Resultado Dinamica: " + perDinamica);
		
		Persona perDinamica1 = this.iPersonaJpaService.buscarDinamicamente("Daniela", "Papa", "F");

		LOG.info("Resultado Dinamica: " + perDinamica1);

	}

}
