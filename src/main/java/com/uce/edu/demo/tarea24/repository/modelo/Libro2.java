package com.uce.edu.demo.tarea24.repository.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {
	
	@Id
	@Column(name = "lib_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lib_id_seq")
	@SequenceGenerator(name = "lib_id_seq", sequenceName = "lib_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "lib_titulo")
	private String titulo;
	
	@Column(name = "lib_cantidad_paginas")
	private Integer cantPaginas;
	
	@OneToMany(mappedBy = "libro2", cascade = CascadeType.ALL)
	private Set<Libro2_Autor2> libro2_autor2;

	@Override
	public String toString() {
		return "Libro2 [id=" + id + ", titulo=" + titulo + ", cantPaginas=" + cantPaginas + ", libro2_autor2="
				+ libro2_autor2 + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(Integer cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public Set<Libro2_Autor2> getLibro2_autor2() {
		return libro2_autor2;
	}

	public void setLibro2_autor2(Set<Libro2_Autor2> libro2_autor2) {
		this.libro2_autor2 = libro2_autor2;
	}

}
