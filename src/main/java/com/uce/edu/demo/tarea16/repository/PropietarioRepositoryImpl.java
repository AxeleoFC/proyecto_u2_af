package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea16.repository.modelo.Propietario;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Propietario p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(cedula));
	}

	@Override
	public void actualizar(Propietario p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, cedula);
		
	}

}
