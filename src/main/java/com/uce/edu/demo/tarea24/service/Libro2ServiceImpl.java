package com.uce.edu.demo.tarea24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea24.repository.ILibro2Repository;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2;
@Service
public class Libro2ServiceImpl implements ILibro2Service {

	@Autowired
	private ILibro2Repository libroRepo;
	
	@Override
	public void insertar(Libro2 l) {
		// TODO Auto-generated method stub
		this.libroRepo.insertar(l);
	}

	@Override
	public void eliminar(String titulo) {
		// TODO Auto-generated method stub
		this.libroRepo.eliminar(titulo);
	}

	@Override
	public void actualizar(Libro2 l) {
		// TODO Auto-generated method stub
		this.libroRepo.actualizar(l);
	}

	@Override
	public Libro2 buscar(String titulo) {
		// TODO Auto-generated method stub
		return this.libroRepo.buscar(titulo);
	}

}
