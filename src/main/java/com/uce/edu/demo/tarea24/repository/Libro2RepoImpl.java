package com.uce.edu.demo.tarea24.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea24.repository.modelo.Autor2;
import com.uce.edu.demo.tarea24.repository.modelo.Libro2;

@Repository
@Transactional
public class Libro2RepoImpl implements ILibro2Repository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Libro2 l) {
		// TODO Auto-generated method stub
		this.entityManager.persist(l);
	}

	@Override
	public void eliminar(String titulo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(titulo));
	}

	@Override
	public void actualizar(Libro2 l) {
		// TODO Auto-generated method stub
		this.entityManager.merge(l);
	}

	@Override
	public Libro2 buscar(String titulo) {
		// TODO Auto-generated method stub
		Query jpqlQuery=this.entityManager.createQuery("SELECT l FROM Libro2 l WHERE l.titulo= :datoLibro");
		jpqlQuery.setParameter("datoLibro", titulo);
		
		//Da un objeto de tipo Persona
		return (Libro2) jpqlQuery.getSingleResult();
	}

}
