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
				
		Persona per =new Persona();
		per.setNombre("Axel");
		per.setApellido("Flores");
		per.setCedula("1258963459");
		per.setGenero("M");
		//this.personaJPACService.guardar(per);
		
		//1 TypedQuery
		Persona perTyped=this.personaJPACService.buscarPorCedulaTyped("1000236598");
		LOG.info("Persona Typed: "+perTyped);
		//2 NamedQuery
		Persona perNamed=this.personaJPACService.buscarPorCedulaNamed("1000236598");
		LOG.info("Persona Named: "+perNamed);
		//3 TypedQuery y NamedQuery
		Persona perTypedNamed=this.personaJPACService.buscarPorCedulaTypedNamed("1000236598");
		LOG.info("Persona TypedNamed: "+perTypedNamed);
		//4 Varios NamedQuery
		List<Persona> listaPersona=this.personaJPACService.buscarPorNombreApellido("Axel","Flores");
		listaPersona.stream().forEach(persona -> {LOG.info("Busqueda de persona por nombre y apellidos: "+persona);});
	}
}
