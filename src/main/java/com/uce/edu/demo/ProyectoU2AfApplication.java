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
import com.uce.edu.demo.tarea24.repository.modelo.Autor2;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2_Autor2;
import com.uce.edu.demo.tarea24.service.IAutor2Service;
import com.uce.edu.demo.tarea24.service.ILibro2Service;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private ILibro2Service libroService;
	@Autowired
	private IAutor2Service autorService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		LOG.info("Insertar un libro con dos autores");
		Libro2 l1=new Libro2();
		l1.setTitulo("Los asesinatos de Manhattan");
		l1.setCantPaginas(544);
		this.libroService.insertar(l1);
		
		Autor2 autor1=new Autor2();
		autor1.setNombre("Lincoln Child");
		this.autorService.insertar(autor1);
		Autor2 autor2=new Autor2();
		autor2.setNombre("Douglas Preston");
		this.autorService.insertar(autor2);
		
		Libro2_Autor2 relacion1=new Libro2_Autor2();
		relacion1.setAutor2(this.autorService.buscar("Lincoln Child"));
		relacion1.setLibro2(this.libroService.buscar("Los asesinatos de Manhattan"));
		
		Libro2_Autor2 relacion2=new Libro2_Autor2();
		relacion2.setAutor2(this.autorService.buscar("Douglas Preston"));
		relacion2.setLibro2(this.libroService.buscar("Los asesinatos de Manhattan"));
		
		Set<Libro2_Autor2> relaciones =new HashSet<Libro2_Autor2>();
		relaciones.add(relacion1);
		relaciones.add(relacion2);
		
		Libro2 libroActualizar=this.libroService.buscar("Los asesinatos de Manhattan");
		libroActualizar.setLibro2_autor2(relaciones);
		
		this.libroService.actualizar(libroActualizar);
		
		LOG.info("Insertar un autor con dos libros");
		relaciones.removeAll(relaciones);
		
		Autor2 au1=new Autor2();
		au1.setNombre("Koshi Tachibana");
		this.autorService.insertar(au1);
		
		Libro2 lib1=new Libro2();
		lib1.setTitulo("Date a Live Vol1");
		lib1.setCantPaginas(245);
		this.libroService.insertar(lib1);
		Libro2 lib2=new Libro2();
		lib2.setTitulo("Date a Live Vol2");
		lib2.setCantPaginas(235);
		this.libroService.insertar(lib2);
		
		Libro2_Autor2 relacion3=new Libro2_Autor2();
		relacion3.setAutor2(this.autorService.buscar("Koshi Tachibana"));
		relacion3.setLibro2(this.libroService.buscar("Date a Live Vol1"));
		
		Libro2_Autor2 relacion4=new Libro2_Autor2();
		relacion4.setAutor2(this.autorService.buscar("Koshi Tachibana"));
		relacion4.setLibro2(this.libroService.buscar("Date a Live Vol2"));
		
		relaciones.add(relacion3);
		relaciones.add(relacion4);
		
		Autor2 autorActualizar=this.autorService.buscar("Koshi Tachibana");
		autorActualizar.setLibro2_autor2(relaciones);
		
		this.autorService.actualizar(autorActualizar);
		
	}
}
