package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.MatriculaVehiculos;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepo;
import com.uce.edu.demo.service.IGestorMatriculacionService;
import com.uce.edu.demo.service.IPropietarioService;
import com.uce.edu.demo.service.IVehiculoService;

@SpringBootApplication
public class PruebaPaP2LoApplication implements CommandLineRunner{
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	@Qualifier("liviano")
	private IVehiculoService vehiculoLivSer;
	@Autowired
	@Qualifier("pesado")
	private IVehiculoService vehiculoPesSer;
	
	@Autowired
	private IGestorMatriculacionService gestMatrServ;

	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2LoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("ford");
		vehi.setPlaca("pdo3562");
		vehi.setPrecio(new BigDecimal(20000));
		vehi.setTipo("liviano");
		this.vehiculoLivSer.crear(vehi);
		vehi.setMarca("FORD");
		vehi.setPlaca("PDO-3562");
		this.vehiculoLivSer.actualizar(vehi);
		Propietario prop = new Propietario();
		prop.setNombre("LUIS");
		prop.setApellido("ORTIZ");
		prop.setCedula("1718496944");
		prop.setFechaNacimiento(LocalDateTime.of(1997, 5, 19, 0, 10));
		this.propietarioService.crear(prop);
		MatriculaVehiculos matr = new MatriculaVehiculos();
		matr.setPropietario(prop);
		matr.setVehiculo(vehi);
		this.gestMatrServ.matricular("PDO-3562", "1718496944");
	}

}
