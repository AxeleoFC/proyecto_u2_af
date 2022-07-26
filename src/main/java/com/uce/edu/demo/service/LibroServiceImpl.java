package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibroRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro;
@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository libroRepo;
	
	@Override
	public void insertar(Libro l) {
		// TODO Auto-generated method stub
		this.libroRepo.insertar(l);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.libroRepo.eliminar(id);
	}

	@Override
	public void actualizar(Libro l) {
		// TODO Auto-generated method stub
		this.libroRepo.actualizar(l);
	}

	@Override
	public Libro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.libroRepo.buscar(id);
	}

}
