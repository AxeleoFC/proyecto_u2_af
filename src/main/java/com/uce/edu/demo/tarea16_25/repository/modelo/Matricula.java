package com.uce.edu.demo.tarea16_25.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	@Id
	@Column(name="matr_numero")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matr_numero_seq")
	@SequenceGenerator(name = "matr_numero_seq", sequenceName = "matr_numero_seq", allocationSize = 1)
	private Integer numero;
	
	@Column(name="matr_fecha")
	private LocalDateTime fechaMatriculacion;
	
	@Column(name="matr_precio")
	private BigDecimal precio;
	
	@OneToOne
	@JoinColumn(name = "vehi_matri_id")
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "prop_matr_id")
	private Propietario propietario;
	
	
	
	@Override
	public String toString() {
		return "Matricula [numero=" + numero + ", fechaMatriculacion=" + fechaMatriculacion + ", precio=" + precio
				+ ", vehiculo=" + vehiculo + ", propietario=" + propietario.getNombre() + "]";
	}
	//SET y GET
	public LocalDateTime getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	public void setFechaMatriculacion(LocalDateTime fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}
	public BigDecimal getPrecioMatriculacion() {
		return precio;
	}
	public void setPrecioMatriculacion(BigDecimal precioMatriculacion) {
		this.precio = precioMatriculacion;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
