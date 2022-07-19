package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String genero;
	private Long cantidad;
	
	public PersonaContadorGenero() {
		// TODO Auto-generated constructor stub
	}

	public PersonaContadorGenero(String genero, Long cantidad) {
		super();
		this.genero = genero;
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", cantidad=" + cantidad + "]";
	}
	
	//SET y GET
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
