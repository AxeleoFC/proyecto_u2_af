package com.uce.edu.demo.tarea22.service;

import com.uce.edu.demo.tarea22.repository.modelo.CiudadanoV;

public interface ICiudadanoPService {
	
	public CiudadanoV buscarPorCedula(String cedula);
	public void insertar(CiudadanoV c);
	public void actualizar(CiudadanoV c);
	public void eliminar(String cedula);

}
