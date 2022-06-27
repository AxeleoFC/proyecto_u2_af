package com.uce.edu.demo;

import org.apache.logging.log4j.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{
	
	static Logger log = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo");
	      
	    log.info("Estoy usando Log4J para comprobar en consola");
	    log.error("Estoy usando Log4J para comprobar errores en consola");
	    log.debug("Hola mundo");
	}

}
