package com.uce.edu.demo.tarea23.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "boleto")
public class Boleto {
	
	@Id
	@Column(name = "bol_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bol_id_seq")
	@SequenceGenerator(name = "bol_id_seq", sequenceName = "bol_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name="bol_numero")
	private String numero;
	
	@Column(name="bol_piso")
	private String puesto;
	
	@Column(name="bol_tipo")
	private String funcion;
	
	@Column(name="bol_hora")
	private LocalDateTime hora;
	
	@ManyToOne
	@JoinColumn(name="pers_id_boleto")
	private PersonaB persona_boleto;

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", numero=" + numero + ", puesto=" + puesto + ", funcion=" + funcion + ", hora="
				+ hora + ", persona_boleto=" + persona_boleto.getNombre() + "]";
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

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public PersonaB getPersona_boleto() {
		return persona_boleto;
	}

	public void setPersona_boleto(PersonaB persona_boleto) {
		this.persona_boleto = persona_boleto;
	}

}
