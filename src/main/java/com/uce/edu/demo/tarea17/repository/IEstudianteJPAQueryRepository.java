package com.uce.edu.demo.tarea17.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea17.repository.modelo.EstudianteQuery;

public interface IEstudianteJPAQueryRepository {
	
	public EstudianteQuery buscar(String c);
	public void insertar(EstudianteQuery e);
	public void actualizar(EstudianteQuery e);
	public void eliminar(String c);
	
	//Typed
	public List<EstudianteQuery> buscarPorFacultad(String facultad);
	public List<EstudianteQuery> buscarPorCarrera(String carrera);
	//Named
	public EstudianteQuery buscarPorCedula(String cedula);
	public List<EstudianteQuery> buscarPorNombre(String nombre);
	//Typed y Named
	public List<EstudianteQuery> buscarPorNombreApellido(String nombre, String apellido);
	public List<EstudianteQuery> buscarPorNombreFacultad(String nombre, String facultad);
}
