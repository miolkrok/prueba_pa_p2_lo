package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {
	
	public void crear(Vehiculo vehiculo);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo vehiculo);
	public void eliminar(String placa);

}
