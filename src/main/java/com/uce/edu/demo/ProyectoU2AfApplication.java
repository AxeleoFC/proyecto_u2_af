package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQueryPorCarrera;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuerySencillo;
import com.uce.edu.demo.tarea17_18_19_20.service.IEstudianteJPAQueryService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private ICiudadanoService ciudadanoService;

	//@Autowired
	//private IEmpleadoService empleadoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Ciudadano ciu1=new Ciudadano();
		ciu1.setNombre("Jose");
		ciu1.setApellido("Vinueza");
		
		Empleado empl1=new Empleado();
		empl1.setCodigoIESS("143145");
		empl1.setSalario(new BigDecimal(150));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		
		this.ciudadanoService.ingresarCiudadano(ciu1);
		
		
	}
}
