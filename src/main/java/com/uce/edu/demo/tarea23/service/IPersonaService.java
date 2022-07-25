package com.uce.edu.demo.tarea23.service;

import com.uce.edu.demo.tarea23.repository.modelo.PersonaB;

public interface IPersonaService {
	
	public PersonaB buscarPorCedula(String cedula);
	public void insertar(PersonaB p);
	public void actualizar(PersonaB p);
	public void eliminar(String cedula);

}
