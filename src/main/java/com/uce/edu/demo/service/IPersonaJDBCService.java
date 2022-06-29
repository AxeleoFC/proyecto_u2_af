package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.to.PersonaTo;

public interface IPersonaJDBCService {
	
	public List<PersonaTo> buscarTodos();
	
	public void guardar(PersonaTo p);
	public void actualizar(PersonaTo p);
	public void eliminar(int id);
	public PersonaTo buscar(int id);

}
