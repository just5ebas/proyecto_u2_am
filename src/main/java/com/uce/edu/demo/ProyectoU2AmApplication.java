package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.service.IEstudianteJdbcService;
import com.uce.edu.demo.tarea13.to.Estudiante;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IEstudianteJdbcService estudianteJdbcService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insertar estudiante
		LOG.info("\n  1. Insertar Estudiante");

		Estudiante e = new Estudiante();
		e.setCedula("1750844787");
		e.setNombre("Ariel");
		e.setApellido("Malnado");
		e.setEdad(21);
		e.setSemestre("Quinto");

		this.estudianteJdbcService.crear(e);

		// Actualizar Estudiante
		LOG.info("\n  2. Actualizar Estudiante");

		e.setApellido("Maldonado");
		e.setSemestre("Sexto");

		this.estudianteJdbcService.renovarInformacion(e);

		// Eliminar Estudiante
		LOG.info("\n  3. Eliminar Estudiante");

		this.estudianteJdbcService.eliminarRegistro("1010101010");

		// Buscar Estudiante
		LOG.info("\n  4. Buscar Estudiante");

		Estudiante est_busqueda = this.estudianteJdbcService.consultar("1710738384");
		LOG.info("Se encontro al estudiante: " + est_busqueda);

	}

}
