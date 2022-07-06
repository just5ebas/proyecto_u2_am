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

		// BUSCAR POR ID
//		LOG.info("Dato con JPA: " + this.iPersonaJpaService.buscar(1));

		// GUARDAR
		Persona p = new Persona();
		p.setCedula("1750121212");
		p.setNombre("Daniela");
		p.setApellido("Maldonado");
		p.setGenero("M");
//		this.iPersonaJpaService.guardar(p);

		// ACTUALIZAR
		Persona p1 = new Persona();
		p1.setId(3);
		p1.setNombre("EdisonA");
		p1.setApellido("CayambeA");
//		this.iPersonaJpaService.actualizar(p1);

		// ELIMINAR
//		this.iPersonaJpaService.eliminar(6);

		// BUSCAR POR CEDULA
		Persona pBusc = this.iPersonaJpaService.buscarXCedula("1750844787");
		LOG.info("Resultado encontrado: " + pBusc);

		// BUSCAR POR APELLIDO
		List<Persona> lista = this.iPersonaJpaService.buscarXApellido("Maldonado");
		for (Persona persLista : lista) {
			LOG.info("Persona de la lista: " + persLista);
		}

	}

}
