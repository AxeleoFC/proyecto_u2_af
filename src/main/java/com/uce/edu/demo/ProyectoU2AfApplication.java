package com.uce.edu.demo;

import java.math.BigDecimal;

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

//similar a log4j
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2AfApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(ProyectoU2AfApplication.class.getName());

	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IHabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2AfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Hotel hotel1=new Hotel();
		hotel1.setNombre("Hilton Colon Quito");
		hotel1.setDireccion("Centro");
		
		this.hotelService.insertar(hotel1);
		
		//Hotel hotel=new Hotel();
		//hotel.setId(1);
		
		Habitacion habi1=new Habitacion();
		habi1.setNumero("A2334");
		habi1.setPiso("10");
		habi1.setTipo("Familiar");
		
		Habitacion habi2=new Habitacion();
		habi2.setHotel(hotel1);
		habi2.setNumero("A4545");
		habi2.setPiso("2");
		habi2.setTipo("Matrimonial");
		
		this.habitacionService.insertar(habi2);
		
		
		
		
	}
}
