package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Hotel;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

//	@Autowired
//	private IHabitacionRepository iHabitacionRepository;

//	@Override
//	public void insertar(Hotel h) {
//		List<Habitacion> habitaciones = h.getHabitaciones();
//		h.setHabitaciones(null);
//		this.entityManager.persist(h);
//
//		// --------------------------------------------------
//		String nombre = h.getNombre();
//		Hotel hotelBusq = null; // Buscamos porque no tenemos el id
//		for (Habitacion hab : habitaciones) {
//			hab.setHotel(hotelBusq);
//			this.iHabitacionRepository.insertar(hab);
//		}
//	}
	
	@Override
	public void insertar(Hotel h) {
		this.entityManager.persist(h);
	}

}
