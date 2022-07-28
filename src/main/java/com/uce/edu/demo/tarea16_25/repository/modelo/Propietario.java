package com.uce.edu.demo.tarea16_25.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario {
	
	@Id
	@Column(name="propi_cedula")
	private String cedula;
	@Column(name="propi_nombre")
	private String nombre;
	@Column(name="propi_apellido")
	private String apellido;
	@Column(name="propi_fNacimiento")
	private LocalDateTime fechaNacimiento;
	
	@OneToMany(mappedBy = "propietario")
	private List<Matricula> matriculas;
	
	@Override
	public String toString() {
		return "Propietario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", matriculas=" + matriculas + "]";
	}
	
	//SET y GET
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}
