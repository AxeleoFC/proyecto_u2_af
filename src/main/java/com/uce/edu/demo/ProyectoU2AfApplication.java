package com.uce.edu.demo;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJDBCService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IPersonaJDBCService personaJDBCService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar
		Persona persona=new Persona();
		persona.setNombre("Pepe");
		persona.setApellido("Paredez");
		persona.setId(1235);
		//this.personaJDBCService.guardar(p);
		
		//Actualizar
		Persona per1=new Persona();
		per1.setNombre("Pepe");
		per1.setApellido("Velez");
		per1.setId(1235);
		//this.personaJDBCService.actualizar(per1);
		
		//Eliminar
		//this.personaJDBCService.eliminar(per1.getId());
		
		//Buscar
		Persona personaBucar=this.personaJDBCService.buscar(3);
		LOG.info("!!PERSONA ENCONTRADA¡¡");
		LOG.info(personaBucar);
	}

}
