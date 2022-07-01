package com.uce.edu.demo.tarea14.repository;

import com.uce.edu.demo.tarea14.repository.modelo.EstudianteJPA;

public interface IEstudianteJPARepo {
	
	public EstudianteJPA buscar(String c);
	public void insertar(EstudianteJPA e);
	public void actualizar(EstudianteJPA e);
	public void eliminar(String c);

}
