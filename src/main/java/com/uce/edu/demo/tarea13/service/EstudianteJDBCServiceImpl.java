package com.uce.edu.demo.tarea13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea13.modelo.Estudiante;
import com.uce.edu.demo.tarea13.repository.IEstudianteJDBCRepo;
@Service
public class EstudianteJDBCServiceImpl implements IEstudianteJDBCService {
	
	@Autowired
	private IEstudianteJDBCRepo estudianteRepo;

	@Override
	public Estudiante buscarEstudiante(String c) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscar(c);
	}

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(e);
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(e);
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(c);
	}

}
