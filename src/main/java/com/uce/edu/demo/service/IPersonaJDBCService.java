package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Persona;

public interface IPersonaJDBCService {
	
	public void guardar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(int id);
	public Persona buscar(int id);

}
