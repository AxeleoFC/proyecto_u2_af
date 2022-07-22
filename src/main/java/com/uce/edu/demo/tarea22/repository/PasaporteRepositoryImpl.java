package com.uce.edu.demo.tarea22.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea22.repository.modelo.Pasaporte;
@Repository
@Transactional
public class PasaporteRepositoryImpl implements IPasaporteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Pasaporte buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Pasaporte.class, numero);
	}

	@Override
	public void insertar(Pasaporte p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(Pasaporte p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorNumero(numero));
	}

}
