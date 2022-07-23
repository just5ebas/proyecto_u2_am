package com.uce.edu.demo.tarea23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea23.repository.IGamerRepository;
import com.uce.edu.demo.tarea23.repository.modelo.Gamer;

@Service
public class GamerServiceImpl implements IGamerService {

	@Autowired
	private IGamerRepository iGamerRepository;

	@Override
	public void insertar(Gamer g) {
		// TODO Auto-generated method stub
		this.iGamerRepository.insertar(g);
	}

	@Override
	public void actualizar(Gamer g) {
		// TODO Auto-generated method stub
		this.iGamerRepository.actualizar(g);
	}

	@Override
	public Gamer buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iGamerRepository.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iGamerRepository.eliminar(id);
	}

}
