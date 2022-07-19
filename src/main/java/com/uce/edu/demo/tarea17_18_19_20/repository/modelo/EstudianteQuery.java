package com.uce.edu.demo.tarea17_18_19_20.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante_query")
@NamedQueries({
	@NamedQuery(name = "EstudianteQuery.buscarPorCedula", query = "SELECT e FROM EstudianteQuery e WHERE e.cedula= :datoCedula"),
	@NamedQuery(name = "EstudianteQuery.buscarPorNombre", query = "SELECT e FROM EstudianteQuery e WHERE e.nombre= :datoNombre"),
	@NamedQuery(name = "EstudianteQuery.buscarPorNombreApellido", query = "SELECT e FROM EstudianteQuery e WHERE e.nombre= :datoNombre AND e.apellido= :datoApellido"),
    @NamedQuery(name = "EstudianteQuery.buscarPorNombreFacultad", query = "SELECT e FROM EstudianteQuery e WHERE e.nombre= :datoNombre AND e.facultad= :datoFacultad")})

//NativeQuery
@NamedNativeQuery(name = "EstudianteQuery.buscarPorFacultadCarrera", query = "SELECT * FROM estudiante_query WHERE estu_facultad = :datoFacultad AND estu_carrera= :datoCarrera", resultClass = EstudianteQuery.class)
@NamedNativeQuery(name = "EstudianteQuery.buscarPorNombreCarrera", query = "SELECT * FROM estudiante_query WHERE estu_nombre = :datoNombre AND estu_carrera= :datoCarrera", resultClass = EstudianteQuery.class)

public class EstudianteQuery {
	@Id
	@Column(name = "estu_cedula")
	private String cedula;
	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_facultad")
	private String facultad;
	@Column(name = "estu_carrera")
	private String carrera;
	
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
