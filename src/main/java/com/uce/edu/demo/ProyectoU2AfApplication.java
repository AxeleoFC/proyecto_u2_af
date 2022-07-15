package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea17_18.repository.modelo.EstudianteQuery;
import com.uce.edu.demo.tarea17_18.service.IEstudianteJPAQueryService;

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
		
		//Uso de Native
		EstudianteQuery estu=this.estudianteJPAService.buscarPorCedulaNative("1752310126");
		LOG.info("Buscar estudiante por cedula: "+estu);
		List<EstudianteQuery> estudianList=this.estudianteJPAService.buscarPorNombreNative("Pepe");
		estudianList.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por nombre: "+estudiante);});
		
		//Uso de NamedNativeQuery
		List<EstudianteQuery> estudianList1=this.estudianteJPAService.buscarPorNombreCarrera("Pepe", "Sistemas");
		estudianList1.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por nombre y carrera: "+estudiante);});
		List<EstudianteQuery> estudianList2=this.estudianteJPAService.buscarPorFacultadCarrera("Ingenieria en ciencias aplicadas.", "Computacion");
		estudianList2.stream().forEach(estudiante -> {LOG.info("Busqueda de esudiante por facultad y carrera: "+estudiante);});
	}
}
