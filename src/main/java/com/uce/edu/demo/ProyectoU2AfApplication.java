package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea14.repository.modelo.EstudianteJPA;
import com.uce.edu.demo.tarea14.service.IEstudianteJPAService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IEstudianteJPAService estudianteJPACService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar
		EstudianteJPA estudiante=new EstudianteJPA();
		estudiante.setCedula("1752310126");
		estudiante.setNombre("Miguelss");
		estudiante.setApellido("Herreras");
		estudiante.setFacultad("Ingenieria en ciencias aplicadas.");
		estudiante.setCarrera("Computacion");
		this.estudianteJPACService.insertar(estudiante);
		
		//Buscar
		LOG.info("Datos con JPA: "+this.estudianteJPACService.buscarEstudiante("1752310126"));

		//Actualizar
		EstudianteJPA estu1=new EstudianteJPA();
		estu1.setCedula("1752310126");
		estu1.setNombre("Miguel");
		estu1.setApellido("Herrera");
		estu1.setFacultad("Ingenieria en ciencias aplicadas.");
		estu1.setCarrera("Computacion");
		this.estudianteJPACService.actualizar(estu1);

		//Buscar
		LOG.info("Datos con JPA: "+this.estudianteJPACService.buscarEstudiante("1752310126"));
				
				
		//Eliminar
		this.estudianteJPACService.eliminar("1752310126");

	}

}
