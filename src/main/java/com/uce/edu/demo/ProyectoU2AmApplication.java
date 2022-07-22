package com.uce.edu.demo;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private ICiudadanoService iCiudadanoService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// INSERTAR

		Ciudadano c1 = new Ciudadano();
		c1.setNombre("Darla");
		c1.setApellido("Manto");
		c1.setCedula("1730215484");
		c1.setFechaNacimiento(LocalDateTime.of(2000, 5, 1, 12, 0));

		Pasaporte p1 = new Pasaporte();
		p1.setFechaCaducidad(LocalDateTime.of(2023, 2, 1, 8, 0));
		p1.setFechaEmision(LocalDateTime.now());
		p1.setNumero("13151418");
		p1.setCiudadano(c1);

		c1.setPasaporte(p1);

		this.iCiudadanoService.insertar(c1);

		// BUSCAR
		Ciudadano busqueda = this.iCiudadanoService.buscar(1);
		LOG.info("Ciudadano encontrado:" + busqueda);

		// ACTUALIZAR
		Pasaporte p2 = new Pasaporte();
		p2.setFechaCaducidad(LocalDateTime.of(2026, 1, 1, 0, 1));
		p2.setFechaEmision(LocalDateTime.now());
		p2.setNumero("16852315");
		p2.setCiudadano(busqueda);

		busqueda.setPasaporte(p2);

		this.iCiudadanoService.actualizar(busqueda);

		// ELIMINAR
		this.iCiudadanoService.eliminar(5);

	}

}
