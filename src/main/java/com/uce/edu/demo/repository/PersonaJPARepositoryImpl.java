package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
@Repository
@Transactional
public class PersonaJPARepositoryImpl implements IPersonaJPARepository {
	
	//Al usar JPA se usa la sentencia para
	//interactuar con la BD
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		//Para de buscar con JPA
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void insertar(Persona p) {
		// TODO Auto-generated method stub
		//Para de insertar con JPA
		this.entityManager.persist(p);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		//Para de acualizar con JPA
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		//Para de eliminar con JPA
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		//Query
		//SQL = SELECT * FROM persona WHERE pers_cedula=''
		//Mapeo: JPQL= SELECT p FROM Persona p WHERE p.cedula= :datoCedula
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula= :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		
		//Da un objeto de tipo Persona
		return (Persona) jpqlQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		
//		//SQL = SELECT * FROM persona WHERE pers_genero=''
//		//Mapeo: JPQL= SELECT p FROM Persona p WHERE p.genero= :datoGenero
//		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero= :datoGenero");
//		jpqlQuery.setParameter("datoGenero", genero);
//				
		return null;
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		
		//SQL = SELECT * FROM persona WHERE pers_apellido=''
		//Mapeo: JPQL= SELECT p FROM Persona p WHERE p.apellido= :datoApellido
		Query myQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		//Para retornar una lista
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}


}
