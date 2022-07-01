package com.uce.edu.demo.tarea14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea14.repository.IEstudianteJPARepo;
import com.uce.edu.demo.tarea14.repository.modelo.EstudianteJPA;

@Service
public class EstudianteJPAServiceImpl implements IEstudianteJPAService {
	
	@Autowired
	private IEstudianteJPARepo estudianteRepo;

	@Override
	public EstudianteJPA buscarEstudiante(String c) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscar(c);
	}

	@Override
	public void insertar(EstudianteJPA e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(e);
	}

	@Override
	public void actualizar(EstudianteJPA e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(e);
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(c);
	}

}
