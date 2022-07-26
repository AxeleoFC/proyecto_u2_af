package com.uce.edu.demo.tarea24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea24.repository.IAutor2Repository;
import com.uce.edu.demo.tarea24.repository.modelo.Autor2;
@Service
public class Autor2ServiceImpl implements IAutor2Service {

	@Autowired
	private IAutor2Repository autorRepo;
	
	@Override
	public void insertar(Autor2 a) {
		// TODO Auto-generated method stub
		this.autorRepo.insertar(a);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.autorRepo.eliminar(nombre);
	}

	@Override
	public void actualizar(Autor2 a) {
		// TODO Auto-generated method stub
		this.autorRepo.actualizar(a);
	}

	@Override
	public Autor2 buscar(String nombre) {
		// TODO Auto-generated method stub
		return this.autorRepo.buscar(nombre);
	}

}
