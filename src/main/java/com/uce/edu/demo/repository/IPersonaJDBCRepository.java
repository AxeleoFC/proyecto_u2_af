package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Persona;

public interface IPersonaJDBCRepository {

	public Persona buscarPorId(int id);
	public void insertar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(int id);
	
}
