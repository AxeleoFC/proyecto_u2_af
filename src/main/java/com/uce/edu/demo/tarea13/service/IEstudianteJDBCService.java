package com.uce.edu.demo.tarea13.service;

import com.uce.edu.demo.tarea13.modelo.Estudiante;

public interface IEstudianteJDBCService {
	
	public Estudiante buscarEstudiante(String c);
	public void insertar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(String c);

}
