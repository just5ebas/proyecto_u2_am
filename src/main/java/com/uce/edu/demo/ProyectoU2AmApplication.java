package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
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
		
		Ciudadano c1 = new Ciudadano();
		c1.setNombre("Julio");
		c1.setApellido("Torres");
		
		Empleado e1 = new Empleado();
		e1.setCodigoIess("131614");
		e1.setSalario(new BigDecimal(150));
		e1.setCiudadano(c1); // Esta linea nos establece la relacion en la tabla Empleado
		
		c1.setEmpleado(e1);
		
		this.iCiudadanoService.insertar(c1);
		
		Ciudadano c2 = new Ciudadano();
		c2.setNombre("Julio");
		c2.setApellido("Torres");
		
		Empleado e2 = new Empleado();
		e2.setCodigoIess("131614");
		e2.setSalario(new BigDecimal(150));
		e2.setCiudadano(c2); 
		
		c2.setEmpleado(e2);
		
//		this.iCiudadanoService.insertar(c1); // Insertar empleado
	}

}
