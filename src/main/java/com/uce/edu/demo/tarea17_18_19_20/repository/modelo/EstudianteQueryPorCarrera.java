package com.uce.edu.demo.tarea17_18_19_20.repository.modelo;

import java.io.Serializable;

public class EstudianteQueryPorCarrera implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String carrera;
	
	private Long cantidad;
	
	public EstudianteQueryPorCarrera() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteQueryPorCarrera(String carrera, Long cantidad) {
		super();
		this.carrera = carrera;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "EstudianteQueryPorCarrera [carrera=" + carrera + ", cantidad=" + cantidad + "]";
	}

	//SET y GET
	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
}
