package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQueryPorCarrera;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuerySencillo;
import com.uce.edu.demo.tarea17_18_19_20.service.IEstudianteJPAQueryService;
import com.uce.edu.demo.tarea22.repository.modelo.Ciudadano;
import com.uce.edu.demo.tarea22.repository.modelo.Pasaporte;
import com.uce.edu.demo.tarea22.service.ICiudadanoPService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private ICiudadanoPService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Tarea 22
		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Jose");
		ciu1.setApellido("Vinueza");
		ciu1.setCedula("1752363212");
		ciu1.setFechaNacimiento(LocalDateTime.of(2000, 01, 16, 17, 52));
		
		Pasaporte pas1=new Pasaporte();
		pas1.setNumero("1452321");
		pas1.setFechaEmision(LocalDateTime.now());
		pas1.setFechaCaducidad(LocalDateTime.now().plusYears(1));
		
		ciu1.setPasaporte(pas1);
		
		this.ciudadanoService.insertar(ciu1);
		LOG.info("Se a insertado al ciudadano:");
		LOG.info(ciu1);
		
		LOG.info("Se a buscado al ciudadano:");
		LOG.info(this.ciudadanoService.buscarPorCedula("1752363212"));
		
		ciu1.setApellido("Martinez");
		this.ciudadanoService.actualizar(ciu1);
		LOG.info("Se a actualizado al ciudadano:");
		LOG.info(this.ciudadanoService.buscarPorCedula("1752363212"));
		

		this.ciudadanoService.eliminar("1752363212");
		LOG.info("Se a eliminado al ciudadano");
		
	}
}
