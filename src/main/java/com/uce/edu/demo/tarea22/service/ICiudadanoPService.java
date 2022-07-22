package com.uce.edu.demo.tarea22.service;

import com.uce.edu.demo.tarea22.repository.modelo.Ciudadano;

public interface ICiudadanoPService {
	
	public Ciudadano buscarPorCedula(String cedula);
	public void insertar(Ciudadano c);
	public void actualizar(Ciudadano c);
	public void eliminar(String cedula);

}
