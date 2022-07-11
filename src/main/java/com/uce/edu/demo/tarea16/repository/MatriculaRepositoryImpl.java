package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea16.repository.modelo.Matricula;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Matricula m) {
		// TODO Auto-generated method stub
		this.entityManager.persist(m);
	}
}

