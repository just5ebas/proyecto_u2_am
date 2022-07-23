package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea23.repository.modelo.Consola;
import com.uce.edu.demo.tarea23.repository.modelo.Gamer;
import com.uce.edu.demo.tarea23.service.IConsolaService;
import com.uce.edu.demo.tarea23.service.IGamerService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private IGamerService iGamerService;

	@Autowired
	private IConsolaService iConsolaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// INSERTAR TABLA PRINCIPAL
		Gamer gamer1 = new Gamer();
		gamer1.setGamertag("FireDamage");
		gamer1.setNombre("Andrea");
		gamer1.setApellido("Garcia");
		gamer1.setPais("Peru");
		gamer1.setEdad(26);

		this.iGamerService.insertar(gamer1);

		// INSERTAR TABLA HIJA
		Consola cons1 = new Consola();
		cons1.setNumSerie("KJRV-N6C5-V651-EFFC");
		cons1.setPlataforma("PC");
		cons1.setNumJuegos(32);

		Gamer gAux = new Gamer();
		gAux.setId(1);

		cons1.setGamer(gAux);

		this.iConsolaService.insertar(cons1);

		// ACTUALIZAR TABLA PRINCIPAL
		gamer1.setGamertag("TinyQueen");
		this.iGamerService.actualizar(gamer1);

		// ACTUALIZAR TABLA HIJA
		cons1.setNumJuegos(35);
		this.iConsolaService.actualizar(cons1);

		// BUSCAR TABLA PADRE
		Gamer gBusq = this.iGamerService.buscar(1);
		LOG.info("Gamer de busqueda: " + gBusq);

		// BUSCAR TABLA HIJA
		Consola cBusq = this.iConsolaService.buscar(4);
		LOG.info("Consola de busqueda: " + cBusq);

		// ELIMINAR TABLA PADRE
		this.iGamerService.eliminar(5);

		// ELIMINAR TABLA HIJA
		this.iConsolaService.eliminar(3);

	}

}
