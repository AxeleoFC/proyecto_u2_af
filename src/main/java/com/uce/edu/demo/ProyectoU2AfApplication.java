package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQueryPorCarrera;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuerySencillo;
import com.uce.edu.demo.tarea17_18_19_20.service.IEstudianteJPAQueryService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IEstudianteJPAQueryService estudianteJPACService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Busqueda sencilla
		List<EstudianteQuerySencillo> listaEstudiante = this.estudianteJPACService.buscarPorCarreraSencillo("Computacion");
		listaEstudiante.stream().forEach(estudiante -> {
			LOG.info("Estudiante sencillo por carrera: " + estudiante);
		});
		
		//Busqueda sencilla con agrupamiento
		String facultad="Ingenieria en ciencias aplicadas.";
		List<EstudianteQueryPorCarrera> listaEstudiante1 = this.estudianteJPACService.consultarEstudiantesPorCarrera(facultad);
		listaEstudiante1.stream().forEach(estudiante -> {
			LOG.info("Estudiantes por carrera de la facultad de "+facultad+" : " + estudiante);
		});
	}
}
