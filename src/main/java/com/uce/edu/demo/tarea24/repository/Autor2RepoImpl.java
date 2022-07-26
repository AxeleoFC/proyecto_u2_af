package com.uce.edu.demo.tarea24.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea24.repository.modelo.Autor2;
@Repository
@Transactional
public class Autor2RepoImpl implements IAutor2Repository {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Autor2 a) {
		// TODO Auto-generated method stub
		this.entityManager.persist(a);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(nombre));
	}

	@Override
	public void actualizar(Autor2 a) {
		// TODO Auto-generated method stub
		this.entityManager.merge(a);
	}

	@Override
	public Autor2 buscar(String nombre) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT a FROM Autor2 a WHERE a.nombre= :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
		
		//Da un objeto de tipo Persona
		return (Autor2) jpqlQuery.getSingleResult();
	}

}
