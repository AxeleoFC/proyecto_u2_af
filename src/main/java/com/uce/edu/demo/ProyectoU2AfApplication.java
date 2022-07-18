package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.tarea17_18_19.repository.modelo.EstudianteQuery;
import com.uce.edu.demo.tarea17_18_19.service.IEstudianteJPAQueryService;

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
		
		// Tarea 19
		
		List<EstudianteQuery> listaEstudiante1 = this.estudianteJPACService.buscarNombreApellidoCriteriaAPI("Pepe", "Jose");
		listaEstudiante1.stream().forEach(estudiante -> {
			LOG.info("Busqueda de estudiante por nombre con Criteria API: " + estudiante);
		});
		
		// Si es de Ingenieria en ciencias aplicada, se busca a los estudiantes
		// con el nombre y apellidos iguales al parametro
		// o puede ser de la carrera dada por el parametro

		// Si es de Medicina, se busca a los estudiantes
		// con el nombre o apellidos iguales al parametro
		// y debe ser de la carrera dada por el parametro
		
		List<EstudianteQuery> listaEstudiante2 = this.estudianteJPACService
				.buscarDinamicamenteNombreApellidoFacultatCarrera("Pepe", "Jose", "Ingenieria en ciencias aplicadas.", "Computacion");
		listaEstudiante2.stream().forEach(estudiante -> {
			LOG.info("Busqueda dinamica de estudiante: " + estudiante);
		});
		
		

	}
}
