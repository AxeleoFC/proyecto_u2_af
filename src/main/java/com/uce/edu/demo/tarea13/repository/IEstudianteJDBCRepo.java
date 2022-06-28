package com.uce.edu.demo.tarea13.repository;

import com.uce.edu.demo.tarea13.modelo.Estudiante;

public interface IEstudianteJDBCRepo {
	
	public Estudiante buscar(String c);
	public void insertar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(String c);

}
