package com.uce.edu.demo.tarea14.service;

import com.uce.edu.demo.tarea14.repository.modelo.EstudianteJPA;

public interface IEstudianteJPAService {
	
	public EstudianteJPA buscarEstudiante(String c);
	public void insertar(EstudianteJPA e);
	public void actualizar(EstudianteJPA e);
	public void eliminar(String c);

}
