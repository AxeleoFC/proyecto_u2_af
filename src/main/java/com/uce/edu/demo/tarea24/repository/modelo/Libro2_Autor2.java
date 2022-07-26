package com.uce.edu.demo.tarea24.repository.modelo;

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
@Table(name = "libro2_autor2")
public class Libro2_Autor2 {
	
	@Id
	@Column(name = "libro2_autor2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro2_autor2_id_seq")
	@SequenceGenerator(name = "libro2_autor2_id_seq", sequenceName = "libro2_autor2_id_seq", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="liau_id_autor2")
	private Autor2 autor2;
	
	@ManyToOne
	@JoinColumn(name="liau_id_libro2")
	private Libro2 libro2;

	//SET y GET
	public Autor2 getAutor2() {
		return autor2;
	}

	public void setAutor2(Autor2 autor2) {
		this.autor2 = autor2;
	}

	public Libro2 getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro2 libro2) {
		this.libro2 = libro2;
	}

}
