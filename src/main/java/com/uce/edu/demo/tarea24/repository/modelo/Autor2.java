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
@Table(name = "autor2")
public class Autor2 {
	
	@Id
	@Column(name = "auto_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auto_id_seq")
	@SequenceGenerator(name = "auto_id_seq", sequenceName = "auto_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "auto_nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "autor2", cascade = CascadeType.ALL)
	private Set<Libro2_Autor2> libro2_autor2;

	@Override
	public String toString() {
		return "Autor2 [id=" + id + ", nombre=" + nombre + ", libro2_autor2=" + libro2_autor2 + "]";
	}

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro2_Autor2> getLibro2_autor2() {
		return libro2_autor2;
	}

	public void setLibro2_autor2(Set<Libro2_Autor2> libro2_autor2) {
		this.libro2_autor2 = libro2_autor2;
	}
	

}
