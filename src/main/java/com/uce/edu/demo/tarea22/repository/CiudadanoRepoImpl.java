package com.uce.edu.demo.tarea22.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea22.repository.modelo.Ciudadano;
@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ciudadano buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.cedula= :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Ciudadano) jpqlQuery.getSingleResult();
	}

	@Override
	public void insertar(com.uce.edu.demo.tarea22.repository.modelo.Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.persist(c);
	}

	@Override
	public void actualizar(com.uce.edu.demo.tarea22.repository.modelo.Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.merge(c);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorCedula(cedula));
	}

}
