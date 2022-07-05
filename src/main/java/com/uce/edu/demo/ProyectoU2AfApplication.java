package com.uce.edu.demo;

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

		//Buscar
		LOG.info("Datos con JPA: "+this.personaJPACService.buscar(3));
		
		//Insertar
		Persona per=new Persona();
		//per.setId(7);
		per.setNombre("Pepe");
		per.setApellido("Perez");
		this.personaJPACService.guardar(per);

		//Actualizar
		Persona per1=new Persona();
		per1.setId(1235);
		per1.setNombre("Andrea");
		per1.setApellido("Solis");
		//this.personaJPACService.actualizar(per1);
				
				
		//Eliminar
		//this.personaJPACService.eliminar(10);

	}

}
