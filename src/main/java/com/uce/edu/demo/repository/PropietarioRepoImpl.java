package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Propietario;

@Repository
public class PropietarioRepoImpl implements IPropietarioRepo{

	@Override
	public void crear(Propietario propietario) {
		// TODO Auto-generated method stub
		System.out.println("crear propietario: " +propietario);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		Propietario pro = new Propietario();
		pro.setCedula(cedula);
		
		return pro;
	}
	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("eliminar propietario: " +cedula);
	}



}
