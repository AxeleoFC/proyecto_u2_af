package com.uce.edu.demo.tarea14.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea14.repository.modelo.EstudianteJPA;

@Repository
@Transactional
public class EstudianteJPARepositoryImpl implements IEstudianteJPARepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EstudianteJPA buscar(String c) {
		// TODO Auto-generated method stub
		return this.entityManager.find(EstudianteJPA.class, c);
	}
	

	@Override
	public void insertar(EstudianteJPA e) {
		// TODO Auto-generated method stub
		this.entityManager.persist(e);
	}

	@Override
	public void actualizar(EstudianteJPA e) {
		// TODO Auto-generated method stub
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(c));
	}


}
