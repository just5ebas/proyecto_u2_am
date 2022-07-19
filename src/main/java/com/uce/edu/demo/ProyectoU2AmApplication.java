package com.uce.edu.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
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

//		PersonaSencilla p1 = new PersonaSencilla();
		
		List<PersonaSencilla> list1 = this.iPersonaJpaService.buscarXApellidoSencillo("Maldonado");
		
		for(PersonaSencilla p : list1) {
			LOG.info("Persona Sencilla: " + p);
		}
		
//		Persona pers1 = new Persona();
//		pers1.setCedula("1512139548");
//		pers1.setNombre("Kevin");
//		pers1.setApellido("Carlosama");
//		pers1.setGenero("M");	
		
//		this.iPersonaJpaService.guardar(pers1);
		
		List<PersonaContadorGenero> list2 = this.iPersonaJpaService.consultarCantidadXGenero();
		
		for(PersonaContadorGenero p : list2) {
			LOG.info("Persona Contador Genero: " + p);
		}
		
	}

}
