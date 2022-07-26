package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.manytomany.Autor;

public interface IAutorRepository {
	
	public void insertar(Autor a);
	public void eliminar(Integer id);
	public void actualizar(Autor a);
	public Autor buscar(Integer id);

}
