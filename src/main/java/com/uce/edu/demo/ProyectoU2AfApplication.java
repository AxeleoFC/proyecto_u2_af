package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea16.repository.modelo.Propietario;
import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;
import com.uce.edu.demo.tarea16.service.IMatriculaGestorService;
import com.uce.edu.demo.tarea16.service.IPropietarioService;
import com.uce.edu.demo.tarea16.service.IVehiculoService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IMatriculaGestorService matriculaService;
	@Autowired
	private IPropietarioService propietarioService;
	@Autowired
	private IVehiculoService vehiculoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				
		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setMarca("Totota");
		vehiculo.setPlaca("PCT8673");
		vehiculo.setPrecio(new BigDecimal(5000));
		vehiculo.setTipo("P");
		this.vehiculoService.ingresarVehiculo(vehiculo);
		LOG.info("Vehiculo guardado");
		
		//2
		vehiculo.setMarca("Toyota");
		vehiculo.setPrecio(new BigDecimal(10000));
		this.vehiculoService.actualizarVehiculo(vehiculo);
		LOG.info("Vehiculo actualizado");
		
		//3
		Propietario p=new Propietario();
		p.setNombre("Axel");
		p.setApellido("Flores");
		p.setCedula("1752310126");
		p.setFechaNacimiento(LocalDateTime.of(2000, 06, 28, 23, 23));
		this.propietarioService.ingresarPropietario(p);
		LOG.info("Propietario guardado");
		
		//4
		this.matriculaService.crearMatricula(p.getCedula(), vehiculo.getPlaca());
		LOG.info("Matricula generada");
		

	}
}
