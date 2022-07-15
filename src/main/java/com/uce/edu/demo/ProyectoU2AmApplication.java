package com.uce.edu.demo;

import java.util.List;

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
	private IEstudianteJpaService iEstudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// BUSCAR POR CEDULA NATIVE
		Estudiante e1 = this.iEstudianteJpaService.buscarPorCedulaNative("1750844787");

		LOG.info("Resultado búsqueda Native: " + e1);

		// BUSCAR POR CEDULA NAMED NATIVE
		Estudiante e2 = this.iEstudianteJpaService.buscarPorCedulaNamedNative("1316915484");

		LOG.info("Resultado búsqueda Named Native: " + e2);

		// BUSCAR POR SEMESTRE NATIVE
		List<Estudiante> list1 = this.iEstudianteJpaService.buscarPorSemestreNative("Sexto", "Noveno");

		list1.stream().forEach(e -> LOG.info("Resultado lista Native:" + e));

		// BUSCAR POR SEMESTRE NATIVE
		List<Estudiante> list2 = this.iEstudianteJpaService.buscarPorSemestreNative("Primero", "Cuarto");

		list2.stream().forEach(e -> LOG.info("Resultado lista Named Native:" + e));

	}

}
