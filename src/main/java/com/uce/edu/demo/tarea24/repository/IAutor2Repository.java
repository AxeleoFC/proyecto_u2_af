package com.uce.edu.demo.tarea24.repository;

import com.uce.edu.demo.tarea24.repository.modelo.Autor2;

public interface IAutor2Repository {
	
	public void insertar(Autor2 a);
	public void eliminar(String nombre);
	public void actualizar(Autor2 a);
	public Autor2 buscar(String nombre);

}
