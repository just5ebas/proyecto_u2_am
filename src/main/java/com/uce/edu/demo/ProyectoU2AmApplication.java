package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.IAutorService;
import com.uce.edu.demo.service.ILibroService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private ILibroService iLibroService;

	@Autowired
	private IAutorService iAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Libro lib = new Libro();
		lib.setTitulo("JPA1");
		lib.setCantidadPaginas(150);

		Autor aut1 = new Autor();
		aut1.setNombre("Alan Straigh");

		Set<Autor> autores = new HashSet<>();
		autores.add(aut1);
		
		lib.setAutores(autores);

		this.iLibroService.insertar(lib);

	}

}
