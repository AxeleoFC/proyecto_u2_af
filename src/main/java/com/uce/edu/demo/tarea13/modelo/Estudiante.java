package com.uce.edu.demo.tarea13.modelo;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private String facultad;
	private String carrera;
	
	
	public Estudiante(String cedula, String nombre, String apellido, String facultad, String carrera) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.facultad = facultad;
		this.carrera = carrera;
	}
	
	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", facultad="
				+ facultad + ", carrera=" + carrera + "]";
	}
	//SET y GET
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	

}
