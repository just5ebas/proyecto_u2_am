package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea16.repository.modelo.Propietario;
import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;
import com.uce.edu.demo.tarea16.service.IMatriculaGestorService;
import com.uce.edu.demo.tarea16.service.IPropietarioService;
import com.uce.edu.demo.tarea16.service.IVehiculoService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IMatriculaGestorService matriculaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Propietario p1 = new Propietario();
		p1.setCedula("1750844787");
		p1.setNombre("Ariel");
		p1.setApellido("Maldonado");
		p1.setFechaNacimiento(LocalDateTime.of(2000, 12, 26, 0, 5));

//		this.iPropietarioService.crear(p1);

		Vehiculo v1 = new Vehiculo();
		v1.setMarca("Toyota");
		v1.setPlaca("PDJ-5652");
		v1.setTipo("P");
		v1.setPrecio(new BigDecimal(15000));

//		this.iVehiculoService.insertar(v1);
		
		this.matriculaGestorService.generar(1, 1);
		
	}

}
