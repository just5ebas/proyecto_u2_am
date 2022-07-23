package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void insertar(Habitacion hab) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hab);
	}

}
