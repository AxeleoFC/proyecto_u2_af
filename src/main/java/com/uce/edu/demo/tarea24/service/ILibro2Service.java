package com.uce.edu.demo.tarea24.service;

import com.uce.edu.demo.tarea24.repository.modelo.Libro2;

public interface ILibro2Service {
	
	public void insertar(Libro2 l);
	public void eliminar(String titulo);
	public void actualizar(Libro2 l);
	public Libro2 buscar(String titulo);

}
