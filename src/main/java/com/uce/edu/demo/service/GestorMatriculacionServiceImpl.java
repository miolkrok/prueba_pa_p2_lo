package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.MatriculaVehiculos;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepo;



@Service
public class GestorMatriculacionServiceImpl implements IGestorMatriculacionService{
	
	@Autowired
	private IPropietarioService propietarioService;
		
	@Autowired
	@Qualifier("liviano")
	private IVehiculoService vehiculoLivi;
	
	@Autowired
	@Qualifier("pesado")
	private IVehiculoService vehiculoPesa;
	
	@Autowired
	private IVehiculoRepo vehiculoRepo;

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub

		System.out.println("Matriculando....");
		Propietario pro = this.propietarioService.buscar(cedula);
		Vehiculo vehi = this.vehiculoRepo.buscar(placa);
		MatriculaVehiculos matveh = new MatriculaVehiculos();
		matveh.setPropietario(pro);
		matveh.setVehiculo(vehi);
		matveh.setFechaMatricula(LocalDateTime.now());
		
		if(vehi.getTipo().equals("liviano") ) {
			BigDecimal matpesado = vehi.getPrecio().multiply(new BigDecimal(10)).divide(new BigDecimal(100));
			matveh.setValorMatricula(matpesado);
			this.vehiculoLivi.crear(vehi);

		}else if(vehi.getTipo().equals("pesado")) {
			BigDecimal matpesado = vehi.getPrecio().multiply(new BigDecimal(15)).divide(new BigDecimal(100));
			matveh.setValorMatricula(matpesado);
			this.vehiculoLivi.crear(vehi);
		}
//		if(matveh.getValorMatricula().compareTo(new BigDecimal(2000))>0) {
//			BigDecimal desc = matveh.getValorMatricula().multiply(new BigDecimal(7)).divide(new BigDecimal(100));
//			BigDecimal pf = matveh.getValorMatricula().subtract(desc);
//			matveh.setValorMatricula(pf);
//		}
	}

}
