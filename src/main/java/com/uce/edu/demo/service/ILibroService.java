package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.manytomany.Libro;

public interface ILibroService {
	
	public void insertar(Libro l);
	public void eliminar(Integer id);
	public void actualizar(Libro l);
	public Libro buscar(Integer id);

}
