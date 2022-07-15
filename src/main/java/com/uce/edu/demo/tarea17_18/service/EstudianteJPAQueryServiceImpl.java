package com.uce.edu.demo.tarea17_18.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea17_18.repository.IEstudianteJPAQueryRepository;
import com.uce.edu.demo.tarea17_18.repository.modelo.EstudianteQuery;

@Service
public class EstudianteJPAQueryServiceImpl implements IEstudianteJPAQueryService {
	
	@Autowired
	private IEstudianteJPAQueryRepository estudianteRepo;

	@Override
	public EstudianteQuery buscarEstudiante(String c) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscar(c);
	}

	@Override
	public void insertar(EstudianteQuery e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertar(e);
	}

	@Override
	public void actualizar(EstudianteQuery e) {
		// TODO Auto-generated method stub
		this.estudianteRepo.actualizar(e);
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.estudianteRepo.eliminar(c);
	}

	// Deber 17
	@Override
	public List<EstudianteQuery> buscarPorFacultad(String facultad) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorFacultad(facultad);
	}

	@Override
	public List<EstudianteQuery> buscarPorCarrera(String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCarrera(carrera);
	}

	@Override
	public EstudianteQuery buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCedula(cedula);
	}

	@Override
	public List<EstudianteQuery> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombre(nombre);
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreFacultad(String nombre, String facultad) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreFacultad(nombre, facultad);
	}

	//Tarea 18
	@Override
	public EstudianteQuery buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorCedulaNative(cedula);
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreNative(nombre);
	}

	@Override
	public List<EstudianteQuery> buscarPorFacultadCarrera(String facultad, String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorFacultadCarrera(facultad, carrera);
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreCarrera(String nombre, String carrera) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarPorNombreCarrera(nombre, carrera);
	}

}
