package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.MatriculaVehiculos;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepo;
import com.uce.edu.demo.repository.IPropietarioRepo;
import com.uce.edu.demo.repository.IVehiculoRepo;

@Service
public class GestorMatriculacionServiceImpl implements IGestorMatriculacionService {

	@Autowired
	private IPropietarioRepo propietarioRepo;

	@Autowired
	private IVehiculoRepo vehiculoRepo;

	@Autowired
	@Qualifier("pesado")
	private IMatriculaVehiculosService matriPesado;
	@Autowired
	@Qualifier("liviano")
	private IMatriculaVehiculosService matriLiviano;
	
	@Autowired
	private IMatriculaRepo matriculaRepo;

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub

		System.out.println("Matriculando....");
		Propietario pro = this.propietarioRepo.buscar(cedula);
		Vehiculo vehi = this.vehiculoRepo.buscar(placa);
		BigDecimal vMatricula;
		
		if (vehi.getTipo().equals("liviano")) {
			vMatricula = this.matriLiviano.calcular(vehi.getPrecio());

		} else  {
			vMatricula = this.matriPesado.calcular(vehi.getPrecio());
		}
		
		if (vMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal desc = vMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			vMatricula = vMatricula.subtract(desc);
		}
		MatriculaVehiculos matveh = new MatriculaVehiculos();
		matveh.setFechaMatricula(LocalDateTime.now());
		matveh.setValorMatricula(vMatricula);
		matveh.setPropietario(pro);
		matveh.setVehiculo(vehi);

		this.matriculaRepo.crear(matveh);
	}

}
