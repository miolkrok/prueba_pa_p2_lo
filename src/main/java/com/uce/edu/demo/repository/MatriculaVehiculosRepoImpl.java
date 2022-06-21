package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.MatriculaVehiculos;

@Repository
public class MatriculaVehiculosRepoImpl implements IMatriculaVehiculosRepo{

	@Override
	public void crear(MatriculaVehiculos matriculaVehiculos) {
		// TODO Auto-generated method stub
		System.out.println("vehiculo matriculado: " +matriculaVehiculos);
	}
	
	

}
