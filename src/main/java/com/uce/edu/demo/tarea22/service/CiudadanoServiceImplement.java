package com.uce.edu.demo.tarea22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea22.repository.ICiudadanoRepo;
import com.uce.edu.demo.tarea22.repository.modelo.Ciudadano;
@Service
public class CiudadanoServiceImplement implements ICiudadanoPService{
	
	@Autowired
	private ICiudadanoRepo ciudadanoRepo;

	@Override
	public Ciudadano buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return ciudadanoRepo.buscarPorCedula(cedula);
	}

	@Override
	public void insertar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.insertar(c);
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.actualizar(c);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.eliminar(cedula);
	}

}
