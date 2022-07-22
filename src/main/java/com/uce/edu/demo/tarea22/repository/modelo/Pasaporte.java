package com.uce.edu.demo.tarea22.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pasaporte")
public class Pasaporte {
	
	@Id
	@Column(name = "pasap_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pasap_id_seq")
	@SequenceGenerator(name = "pasap_id_seq", sequenceName = "pasap_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="pasap_numero")
	private String numero;
	
	@Column(name="pasap_fecha_emision")
	private LocalDateTime fechaEmision;
	
	@Column(name="pasap_fecha_caducidad")
	private LocalDateTime fechaCaducidad;
	
	@OneToOne
	@JoinColumn(name="pasap_id_ciudadano")
	private Ciudadano ciudadano;

	@Override
	public String toString() {
		return "Pasaporte [id=" + id + ", numero=" + numero + ", fechaEmision=" + fechaEmision + ", fechaCaducidad="
				+ fechaCaducidad + ", ciudadano=" + ciudadano + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDateTime getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDateTime fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

}
