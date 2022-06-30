package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.repository.to.Estudiante;
import com.uce.edu.demo.tarea13.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. Insertar
		Estudiante e1 = new Estudiante();
		e1.setCedula("1728394560");
		e1.setNombre("Carolina");
		e1.setApellido("Tito");
		e1.setEdad(24);
		e1.setSemestre("Tercero");

		this.estudianteJpaService.crear(e1);

		// 2. Actualizar
		Estudiante e2 = new Estudiante();
		e2.setCedula("1750844787");
		e2.setNombre("Ariel");
		e2.setApellido("Maldonado");
		e2.setEdad(22);
		e2.setSemestre("Sexto");

		this.estudianteJpaService.renovarInformacion(e2);

		// 3. Eliminar
		this.estudianteJpaService.eliminarRegistro("1710738384");

		// 4. Buscar
		Estudiante e3 = this.estudianteJpaService.consultar("1750844787");
		LOG.info("Se encontro al estudiante: " + e3);

	}

}
