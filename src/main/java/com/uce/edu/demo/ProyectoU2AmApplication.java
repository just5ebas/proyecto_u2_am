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
	private IEstudianteJpaService estudianteJpaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// INSERTAR ESTUDIANTE
		Estudiante e1 = new Estudiante();
		e1.setCedula("1615141891");
		e1.setNombre("Nicole");
		e1.setApellido("Moncayo");
		e1.setEdad(21);
		e1.setSemestre("Cuarto");

		Estudiante e2 = new Estudiante();
		e2.setCedula("1316129002");
		e2.setNombre("Ariel");
		e2.setApellido("Manada");
		e2.setEdad(25);
		e2.setSemestre("Sexto");

//		this.estudianteJpaService.crear(e1);
//		this.estudianteJpaService.crear(e2);

		// BUSQUEDAS

		// 1. BUSCAR TODOS
		LOG.info("\nBúsqueda 1: BUSCAR TODOS.");
		List<Estudiante> lista1 = this.estudianteJpaService.buscarTodos();
		lista1.stream().forEach(e -> LOG.info("Búsqueda 1: " + e));

		// 2. BUSCAR TODOS ORDENADOR POR APELLIDO
		LOG.info("\nBúsqueda 2: BUSCAR TODOS ORDENADOS POR APELLIDO.");
		List<Estudiante> lista2 = this.estudianteJpaService.buscarTodosOrdenados();
		lista2.stream().forEach(e -> LOG.info("Búsqueda 2: " + e));

		// 3. BUSCAR POR APELLIDO
		LOG.info("\nBúsqueda 3: BUSCAR POR APELLIDO.");
		List<Estudiante> lista3 = this.estudianteJpaService.buscarPorApellido("Moncayo");
		lista3.stream().forEach(e -> LOG.info("Búsqueda 3: " + e));
		
		// 4. BUSCAR POR NOMBRE
		LOG.info("\nBúsqueda 4: BUSCAR POR NOMBRE.");
		List<Estudiante> lista4 = this.estudianteJpaService.buscarPorNombre("Ariel");
		lista4.stream().forEach(e -> LOG.info("Búsqueda 4: " + e));

		// 5. BUSCAR POR SEMESTRES
		LOG.info("\nBúsqueda 5: BUSCAR POR SEMESTRES.");
		List<Estudiante> lista5 = this.estudianteJpaService.buscarPorSemestre("Sexto", "Cuarto");
		lista5.stream().forEach(e -> LOG.info("Búsqueda 5: " + e));

		// 6. BUSCAR POR RANGO DE EDAD
		LOG.info("\nBúsqueda 6: BUSCAR POR RANGO DE EDAD.");
		List<Estudiante> lista6 = this.estudianteJpaService.buscarPorEdad(21, 24);
		lista6.stream().forEach(e -> LOG.info("Búsqueda 6: " + e));

	}

}
