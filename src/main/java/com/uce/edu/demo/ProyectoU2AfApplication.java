package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea17.repository.modelo.EstudianteQuery;
import com.uce.edu.demo.tarea17.service.IEstudianteJPAQueryService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());
	
	@Autowired
	private IEstudianteJPAQueryService estudianteJPAService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//1 TypedQuery
		List<EstudianteQuery> estudianList1=this.estudianteJPAService.buscarPorFacultad("Ingenieria en ciencias aplicadas.");
		estudianList1.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por facultad: "+estudiante);});
		List<EstudianteQuery> estudianList2=this.estudianteJPAService.buscarPorCarrera("Computacion");
		estudianList2.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por carrera: "+estudiante);});
		//2 NamedQuery
		EstudianteQuery estu=this.estudianteJPAService.buscarPorCedula("1752310126");
		LOG.info("Buscar estudiante por cedula: "+estu);
		List<EstudianteQuery> estudianList3=this.estudianteJPAService.buscarPorNombre("Emily");
		estudianList3.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por nombre: "+estudiante);});
		//3 TypedQuery y NamedQuery
		List<EstudianteQuery> estudianList4=this.estudianteJPAService.buscarPorNombreApellido("Pepe","Paredez");
		estudianList4.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por nombre y apellido: "+estudiante);});
		List<EstudianteQuery> estudianList5=this.estudianteJPAService.buscarPorNombreFacultad("Emily","Medicina.");
		estudianList4.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por nombre y facultad: "+estudiante);});
	
	}
}
