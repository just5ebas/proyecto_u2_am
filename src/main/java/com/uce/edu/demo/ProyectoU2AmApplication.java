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
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaGestorService iMatriculaGestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// 1. crear vehiculo
		Vehiculo v = new Vehiculo();
		v.setMarca("Totota");
		v.setPlaca("PCJ-6064");
		v.setPrecio(new BigDecimal(50000));
		v.setTipo("P");

		this.iVehiculoService.insertar(v);

		Vehiculo v1 = new Vehiculo();
		v1.setMarca("Chevrolet");
		v1.setPlaca("PPG-2232");
		v1.setPrecio(new BigDecimal(37500));
		v1.setTipo("L");

		this.iVehiculoService.insertar(v1);

		// 2. Actualizar vehiculo
		v.setPrecio(new BigDecimal(40000));
		v.setMarca("Toyota");

		this.iVehiculoService.actualizar(v);

		// 3. Crear propietario
		Propietario p = new Propietario();
		p.setNombre("Ariel");
		p.setApellido("Maldonado");
		p.setCedula("1750844787");
		p.setFechaNacimiento(LocalDateTime.of(2000, 12, 26, 0, 5));

		this.iPropietarioService.crear(p);

		// 4. Crear matricula
		this.iMatriculaGestorService.generar(p.getCedula(), v.getPlaca());

	}

}
