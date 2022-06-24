package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

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
		System.out.println("se vehiculo buscado el vehiculo: " +cedula);
		Propietario pro = new Propietario();
		pro.setCedula(cedula);
		pro.setApellido("ORTIZ");
		pro.setFechaNacimiento(LocalDateTime.now());
		pro.setNombre("LUIS");
		return pro;
	}
	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("eliminar propietario: " +cedula);
	}



}
