package com.uce.edu.demo.tarea17_18_19.repository;

import java.util.List;

import com.uce.edu.demo.tarea17_18_19.repository.modelo.EstudianteQuery;

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
	
	//Tarea 18
	// NativeQuery
	public EstudianteQuery buscarPorCedulaNative(String cedula);
	public List<EstudianteQuery> buscarPorNombreNative(String nombre);
	// NamedNativeQuery
	public List<EstudianteQuery> buscarPorFacultadCarrera(String facultad, String carrera);
	public List<EstudianteQuery> buscarPorNombreCarrera(String nombre, String carrera);
	
	//Tarea 19
	public List<EstudianteQuery> buscarNombreApellidoCriteriaAPI(String nombre, String apellido);
	public List<EstudianteQuery> buscarDinamicamenteNombreApellidoFacultatCarrera(String nombre, String apellido, String facultada, String carrera);

	
	
}
