package com.uce.edu.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.ILibroService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private ILibroService libroService;
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Libro l1=new Libro();
		l1.setTitulo("Date a Live");
		l1.setCantidaPaginas(235);
		
		Libro l2=new Libro();
		l2.setTitulo("JPA");
		l2.setCantidaPaginas(200);
		
		Set<Autor> listaAutor=new HashSet<>();
		
		Autor autor1=new Autor();
		autor1.setNombre("Koushi Tachibana");
		
		Autor autor2=new Autor();
		autor2.setNombre("Adam");
		
		listaAutor.add(autor2);
		l2.setAutores(listaAutor);
		
		this.libroService.insertar(l2);
		
		listaAutor.removeAll(listaAutor);
		listaAutor.add(autor1);
		
		l1.setAutores(listaAutor);
		
		this.libroService.insertar(l1);
		
	}
}
