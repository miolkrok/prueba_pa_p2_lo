package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.MatriculaVehiculos;
import com.uce.edu.demo.repository.IMatriculaVehiculosRepo;

@Service
public class MatriculaVehiculosServiceImpl implements IMatriculaVehiculosService{
	
	@Autowired
	private IMatriculaVehiculosRepo matriculaVehiculosRepo;

	@Override
	public void crear(MatriculaVehiculos matriculaVehiculos) {
		// TODO Auto-generated method stub
		this.matriculaVehiculosRepo.crear(matriculaVehiculos);
	}

}
