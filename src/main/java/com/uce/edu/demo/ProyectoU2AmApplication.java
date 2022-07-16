package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
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

		// CRITERIA API
		// Búsqueda 1
		// Buscar a los estudiantes por su genero, si son hombres mostrar unicamente los
		// que pertenezcan a la carrera mencionada. Si son mujeres, no se hara ninguna
		// comparacion, y se devolveran todas las mujeres.
		List<Estudiante> list1 = this.estudianteJpaService.busquedaDinamica1("Psicologia", "F");

		List<Estudiante> list2 = this.estudianteJpaService.busquedaDinamica1("Ing. en Computación", "M");

		list1.stream().forEach(e -> LOG.info("Resultado de la Búsqueda dinámica 1, caso 1: " + e));
		list2.stream().forEach(e -> LOG.info("Resultado de la Búsqueda dinámica 1, caso 2: " + e));

		// Búsqueda 2
		// Este metodo buscara a los estudiantes de cuarto semestre. Si no son parte de
		// ese semestre, entonces buscara a los estudiantes dentro del rango de edad.

		List<Estudiante> list3 = this.estudianteJpaService.busquedaDinamica2(19, 35, "Cuarto");

		List<Estudiante> list4 = this.estudianteJpaService.busquedaDinamica2(20, 24, "Séptimo");

		list3.stream().forEach(e -> LOG.info("Resultado de la Búsqueda dinámica 2, caso 1: " + e));
		list4.stream().forEach(e -> LOG.info("Resultado de la Búsqueda dinámica 2, caso 2: " + e));
	}

}
