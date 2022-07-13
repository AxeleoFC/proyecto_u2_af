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
		
		// NativeQuery
		Persona perTyped = this.personaJPACService.buscarPorCedulaNative("1000236598");
		LOG.info("Persona NativeQuery: " + perTyped);
		
		// NativeQuery con uso de Named y Typed
		Persona perTyped1 = this.personaJPACService.buscarPorCedulaNamedNative("1000236598");
		LOG.info("Persona NativeQuery con Named y Typed: " + perTyped1);

	}
}
