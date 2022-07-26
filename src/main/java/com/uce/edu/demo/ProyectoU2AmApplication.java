package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor1;
import com.uce.edu.demo.repository.modelo.manytomany.Libro1;
import com.uce.edu.demo.service.IAutor1Service;
import com.uce.edu.demo.service.ILibro1Service;
import com.uce.edu.demo.service.ILibroAutorService;

@SpringBootApplication
public class ProyectoU2AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ProyectoU2AmApplication.class);

	@Autowired
	private ILibro1Service iLibro1Service;

	@Autowired
	private IAutor1Service iAutor1Service;

	@Autowired
	private ILibroAutorService libroAutorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Libro1 l1 = new Libro1();
		l1.setTitulo("Moon Knight #1");
		l1.setCantidadPaginas(51);

		Autor1 a1 = new Autor1();
		a1.setNombre("Doug Moench");

		Autor1 a2 = new Autor1();
		a2.setNombre("Don Perlin");

		this.iLibro1Service.insertar(l1);
		this.iAutor1Service.insertar(a1);
		this.iAutor1Service.insertar(a2);

		this.libroAutorService.insertar(a1.getNombre(), l1.getTitulo());
		this.libroAutorService.insertar(a2.getNombre(), l1.getTitulo());

	}

}
