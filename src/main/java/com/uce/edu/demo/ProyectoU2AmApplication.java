package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IHotelService iHotelService;

	@Autowired
	private IHabitacionService iHabitacionService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Hotel h1 = new Hotel();
		h1.setNombre("Hilton Colon Quito");
		h1.setDireccion("Patria");

//		this.iHotelService.insertar(h1);

		Hotel h2 = new Hotel();
		h2.setNombre("Hilton Colon Guayaquil");
		h2.setDireccion("Malecon");

//		this.iHotelService.insertar(h2);

		Habitacion hab1 = new Habitacion();
		hab1.setNumero("A234");
		hab1.setPiso("10");
		hab1.setTipo("Familiar");

		Hotel h3 = new Hotel();
		h3.setId(1);
		hab1.setHotel(h3);

		this.iHabitacionService.insertar(hab1);

		Habitacion hab2 = new Habitacion();
		hab2.setNumero("B151");
		hab2.setPiso("2");
		hab2.setTipo("Matrimonial");
		hab2.setHotel(h3);
		
		this.iHabitacionService.insertar(hab2);

	}

}
