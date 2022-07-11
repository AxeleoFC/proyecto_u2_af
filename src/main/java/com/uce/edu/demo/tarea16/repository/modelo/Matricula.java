package com.uce.edu.demo.tarea16.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="matr_propietario_cedula")
	private String propietarioCedula;
	
	@Column(name="matr_vehiculo_placa")
	private String vehiculoPlaca;
	
	
	@Override
	public String toString() {
		return "Matricula [fechaMatriculacion=" + fechaMatriculacion + ", precioMatriculacion=" + precio
				+ ", propietarioCedula=" + propietarioCedula + ", vehiculoPlaca=" + vehiculoPlaca + "]";
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

	public String getPropietarioCedula() {
		return propietarioCedula;
	}

	public void setPropietarioCedula(String propietarioCedula) {
		this.propietarioCedula = propietarioCedula;
	}

	public String getVehiculoPlaca() {
		return vehiculoPlaca;
	}

	public void setVehiculoPlaca(String vehiculoPlaca) {
		this.vehiculoPlaca = vehiculoPlaca;
	}
	

}
