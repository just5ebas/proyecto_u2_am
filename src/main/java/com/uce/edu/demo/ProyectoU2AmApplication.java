package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea13.repository.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.modelo.Pasante;
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

		Estudiante estu1 = new Estudiante();
		estu1.setCedula("1695423535");
		estu1.setNombre("Carolina");
		estu1.setApellido("Montalvo");
		estu1.setEdad(24);
		estu1.setGenero("F");
		estu1.setSemestre("Tercero");
		estu1.setCarrera("Ing. Quimica");

		Pasante ps1 = new Pasante();
		ps1.setEstudiante(estu1);
		ps1.setHorasPorCumplir(180);
		ps1.setHorasCumplidas(20);
		ps1.setNombreEmpresa("Martinizing");
		ps1.setRecibePago(Boolean.TRUE);

		estu1.setPasante(ps1);
		
		this.iEstudianteJpaService.crear(estu1);

	}

}
