package com.uce.edu.demo.tarea16.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea16.repository.IMatriculaRepository;
import com.uce.edu.demo.tarea16.repository.IPropietarioRepository;
import com.uce.edu.demo.tarea16.repository.IVehiculoRepository;
import com.uce.edu.demo.tarea16.repository.modelo.Matricula;
import com.uce.edu.demo.tarea16.repository.modelo.Propietario;
import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService {

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;

	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;

	@Override
	public void generar(Integer idProp, Integer idVehi) {
		// TODO Auto-generated method stub
		Propietario p = this.iPropietarioRepository.consultar(idProp);
		Vehiculo v = this.iVehiculoRepository.buscar(idProp);

		String tipo = v.getTipo();
		BigDecimal valorMatricula;

		if (tipo.equalsIgnoreCase("P")) {
			valorMatricula = this.matriculaServicePesado.calcular(v.getPrecio());
		} else {
			valorMatricula = this.matriculaServiceLiviano.calcular(v.getPrecio());
		}

		if (valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal dscto = valorMatricula.multiply(new BigDecimal(0.07));
			valorMatricula = valorMatricula.subtract(dscto);
		}

		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setPropietario(p);
		matricula.setValor(valorMatricula);
		matricula.setVehiculo(v);

		this.iMatriculaRepository.crear(matricula);

	}

}
