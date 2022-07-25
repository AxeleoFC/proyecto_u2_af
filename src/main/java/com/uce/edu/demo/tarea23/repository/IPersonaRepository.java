package com.uce.edu.demo.tarea23.repository;

import com.uce.edu.demo.tarea23.repository.modelo.PersonaB;

public interface IPersonaRepository {
	
	public PersonaB buscarPorCedula(String cedula);
	public void insertar(PersonaB p);
	public void actualizar(PersonaB p);
	public void eliminar(String cedula);

}
