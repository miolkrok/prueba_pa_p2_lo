package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Propietario;

public interface IPropietarioRepo {
	
	public void crear(Propietario propietario);
	public Propietario buscar(String cedula);
	public void eliminar(String cedula);

}
