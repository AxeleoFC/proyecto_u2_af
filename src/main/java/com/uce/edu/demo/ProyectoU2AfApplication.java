package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Habitacion;
import com.uce.edu.demo.repository.modelo.onetomany.Hotel;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;
import com.uce.edu.demo.repository.modelo.onetoone.Empleado;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IHabitacionService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.tarea23.repository.modelo.Boleto;
import com.uce.edu.demo.tarea23.repository.modelo.PersonaB;
import com.uce.edu.demo.tarea23.service.IBoletosService;
import com.uce.edu.demo.tarea23.service.IPersonaService;

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IPersonaService personaService;
	@Autowired
	private IBoletosService boletoService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insertar persona
		PersonaB per=new PersonaB();
		per.setNombre("Axel");
		per.setApellido("Flores");
		per.setCedula("1752310126");
		per.setNumero("0998546532");
		
		this.personaService.insertar(per);
		LOG.info("Se a insertado a la persona:");
		LOG.info(per);
		
		Boleto b1=new Boleto();
		b1.setNumero("10");
		b1.setPuesto("G12");
		b1.setFuncion("Avengers");
		b1.setHora(LocalDateTime.of(2019, 8, 12, 22, 15));
		b1.setPersona_boleto(per);
		
		this.boletoService.insertar(b1);
		
		Boleto b2=new Boleto();
		b2.setNumero("11");
		b2.setPuesto("G13");
		b2.setFuncion("Avengers");
		b2.setHora(LocalDateTime.of(2019, 8, 12, 22, 15));
		b2.setPersona_boleto(per);
		
		this.boletoService.insertar(b2);
		
		Boleto b3=new Boleto();
		b3.setNumero("12");
		b3.setPuesto("G14");
		b3.setFuncion("Avengers");
		b3.setHora(LocalDateTime.of(2019, 8, 12, 22, 15));
		b3.setPersona_boleto(per);
		
		this.boletoService.insertar(b3);
		
		//Buscar
		LOG.info("Se a buscado a la persona:");
		LOG.info(this.personaService.buscarPorCedula("1752310126"));
		
		
		//Actualizar
		PersonaB per1=new PersonaB();
		per1.setNombre("Axel");
		per1.setApellido("Flores");
		per1.setCedula("1752310126");
		per1.setNumero("0998452369");
		
		this.personaService.actualizar(per1);
		
		LOG.info("Se a actualizado a la persona:");
		LOG.info(this.personaService.buscarPorCedula("1752310126"));
		
		//Eliminar
		LOG.info("Se a eliminado a la persona:");
		this.personaService.eliminar("1752310126");
		
		
	}
}
