package com.uce.edu.demo.tarea16_25.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.uce.edu.demo.cajero.repository.modelo.Ciudadano;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id
	@Column(name="vehi_placa")
	private String placa;
	@Column(name="vehi_marca")
	private String marca;
	@Column(name="vehi_tipo")
	private String tipo;
	@Column(name="vehi_precio")
	private BigDecimal precio;
	
	@OneToOne(mappedBy = "vehiculo")
	private Matricula matricula;
	
	
	
	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", tipo=" + tipo + ", precio=" + precio
				+ ", matricula=" + matricula + "]";
	}
	//SET y GET
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
