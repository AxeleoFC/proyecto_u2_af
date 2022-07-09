package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJPAService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IPersonaJPAService personaJPACService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
				
		//Actualizar con JPQL
		int resultados=this.personaJPACService.actualizarPorApellido("Femenino", "Perez");
		LOG.info("Cantidad de registros actualizados: "+resultados);
		
		//Actualizar con JPQL
		int resultados2=this.personaJPACService.eliminarPorGenero("M");
		LOG.info("Cantidad de registros eliminados: "+resultados2);
		

	}
}
