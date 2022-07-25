package com.uce.edu.demo.tarea23.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea23.repository.modelo.PersonaB;
@Repository
@Transactional
public class PersonaRepoImpl implements IPersonaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PersonaB buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(PersonaB.class, cedula);
	}

	@Override
	public void insertar(PersonaB p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(PersonaB p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorCedula(cedula));
	}

}
