package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.LibroAutor;

@Service
public class LibroAutorServiceImpl implements ILibroAutorService {

	@Autowired
	private IAutor1Service autor1Service;

	@Autowired
	private ILibro1Service libro1Service;

	@Autowired
	private ILibroAutorRepository libroAutorRepository;

	@Override
	public void insertar(String nombreAutor, String nombreLibro) {
		// TODO Auto-generated method stub
		LibroAutor libroAutor = new LibroAutor();

		libroAutor.setAutor(this.autor1Service.buscarPorNombre(nombreAutor));
		libroAutor.setLibro(this.libro1Service.buscarPorTitulo(nombreLibro));

		this.libroAutorRepository.insertar(libroAutor);
	}

}
