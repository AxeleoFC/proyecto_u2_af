package com.uce.edu.demo.tarea17_18_19_20.repository.modelo;

import java.io.Serializable;

public class EstudianteQuerySencillo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	private String carrera;
	
	public EstudianteQuerySencillo() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteQuerySencillo(String nombre, String carrera) {
		super();
		this.nombre = nombre;
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "EstudianteQuerySencillo [nombre=" + nombre + ", carrera=" + carrera + "]";
	}
	
	//SET y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	
}
