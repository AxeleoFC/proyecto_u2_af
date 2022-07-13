package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJPARepository {
	
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorApellido(String apellido);
	public Persona buscarPorCedula(String cedula);
	
	public Persona buscarPorId(Integer id);
	public void insertar(Persona p);
	public void actualizar(Persona p);
	public void eliminar(Integer id);
	
	public int  actualizarPorApellido(String genero, String apellido);
	public int  eliminarPorGenero(String genero);
	
	//Typed y Named
	public Persona buscarPorCedulaTyped(String cedula);
	public Persona buscarPorCedulaNamed(String cedula);
	public Persona buscarPorCedulaTypedNamed(String cedula);
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido);
	
	//NativeQuery
	public Persona buscarPorCedulaNative(String cedula);
	public Persona buscarPorCedulaNamedNative(String cedula);
	
	//Criterial API
	public Persona buscarPorCedulaCriterialAPI(String cedula);

}
