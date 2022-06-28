package com.uce.edu.demo;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJDBCService;
import com.uce.edu.demo.tarea13.modelo.Estudiante;
import com.uce.edu.demo.tarea13.service.IEstudianteJDBCService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IEstudianteJDBCService estudianteJDBCService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar
		Estudiante estudiante=new Estudiante();
		estudiante.setCedula("1752310126");
		estudiante.setNombre("Axelfff");
		estudiante.setApellido("Florres");
		estudiante.setFacultad("Ingenieria en ciencias aplicadas.");
		estudiante.setCarrera("Computacion");
		this.estudianteJDBCService.insertar(estudiante);
		
		//Buscar
		Estudiante estudianteBucar=this.estudianteJDBCService.buscarEstudiante(estudiante.getCedula());
		LOG.info("!!ESTUDIANTE ENCONTRADO¡¡");
		LOG.info(estudianteBucar);
		
		//Actualizar
		Estudiante estu1=new Estudiante();
		estu1.setCedula("1752310126");
		estu1.setNombre("Axel");
		estu1.setApellido("Flores");
		estu1.setFacultad("Ingenieria en ciencias aplicadas.");
		estu1.setCarrera("Computacion");
		this.estudianteJDBCService.actualizar(estu1);
		
		//Buscar
		estudianteBucar=this.estudianteJDBCService.buscarEstudiante(estu1.getCedula());
		LOG.info("!!ESTUDIANTE ACTUALIZADO ENCONTRADO¡¡");
		LOG.info(estudianteBucar);
		
		//Eliminar
		this.estudianteJDBCService.eliminar(estu1.getCedula());
		LOG.info("!!ESTUDIANTE ELIMINADO¡¡");
		
		
	}

}
