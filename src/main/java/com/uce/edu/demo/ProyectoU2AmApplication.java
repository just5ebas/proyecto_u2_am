package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteContadorCarrera;
import com.uce.edu.demo.tarea13.repository.modelo.EstudianteSencillo;
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

		// Contar el numero de estudiantes por carrera
		List<EstudianteContadorCarrera> list1 = this.estudianteJpaService
				.buscarCantidadPorCarrera("Ing. en Computación");
		list1.stream().forEach(e -> LOG.info("Contador Carrera: " + e));

		// Devolver nombre, apellido y genero de los estudiantes cuyo apellido inicie
		// con la letra dada
		List<EstudianteSencillo> list2 = this.estudianteJpaService.buscarPorApellidoSencillo("M");
		list2.stream().forEach(e -> LOG.info("Estudiante Sencillo: " + e));

	}

}
