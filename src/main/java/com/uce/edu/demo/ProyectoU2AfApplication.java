package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSensilla;
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
		// Criteria API
//		
//		Persona perTyped = this.personaJPACService.buscarPorCedulaCriterialAPI("1752310126");
//		LOG.info("Persona Criteria API: " + perTyped);
//
//		List<Persona> listaPersona = this.personaJPACService.buscarDinamicamente("Elizabeth", "Mejia", "F");
//		listaPersona.stream().forEach(persona -> {
//			LOG.info("Persona Dinamica: " + persona);
//		});
		
		List<PersonaSensilla> listaPersona = this.personaJPACService.buscarPorApellidoSensillo("Flores");
		listaPersona.stream().forEach(persona -> {
			LOG.info("Persona sensilla: " + persona);
		});
		
		List<PersonaContadorGenero> listaPersona1 = this.personaJPACService.consultarCantidadPorGenero();
		listaPersona1.stream().forEach(persona -> {
			LOG.info("Personas por genero: " + persona);
		});
	}
}
