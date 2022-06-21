package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;

@Repository
public class VehiculoRepoImpl implements IVehiculoRepo{

	@Override
	public void crear(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		System.out.println("se ingreso el vehiculo: " +vehiculo);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("se vehiculo buscado el vehiculo: " +placa);
		Vehiculo vehi = new Vehiculo();
		vehi.setPlaca(placa);
		vehi.setPrecio(vehi.getPrecio());
		vehi.setMarca(vehi.getMarca());
		vehi.setTipo(vehi.getTipo());
		return vehi;
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		System.out.println("se ingreso el vehiculo: " +vehiculo);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("se elimino el vehiculo: " +placa);
	}

}
