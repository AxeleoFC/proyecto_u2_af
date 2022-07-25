package com.uce.edu.demo.tarea23.repository.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "persona_boleto")
public class PersonaB {
	
	@Id
	@Column(name = "per_bol_cedula")
	private String cedula;
	
	@Column(name="per_bol_nombre")
	private String nombre;
	
	@Column(name="per_bol_apellido")
	private String apellido;
	
	@Column(name="per_bol_numero")
	private String numero;
	
	@OneToMany(mappedBy = "persona_boleto")
	private List<Boleto> boletos;

	@Override
	public String toString() {
		return "PersonaC [cedula=" + cedula +", nombre=" + nombre + ", apellido=" + apellido
				+ ", numero=" + numero + ", boletos=" + boletos + "]";
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

}
