package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		// ACTUALIZAR POR APELLIDO CON JPQL
		int resultado = this.iPersonaJpaService.actualizarPorApellido("MA", "Maldonado");

		LOG.info("Cantidad de registros actualizados: " + resultado);

		// ELIMINAR POR GENERO CON JPQL
		int resul = this.iPersonaJpaService.eliminarPorGenero("M");

		LOG.info("Cantidad de registros eliminados: " + resul);

	}

}
