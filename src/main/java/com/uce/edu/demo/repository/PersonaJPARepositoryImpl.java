package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
@Repository
@Transactional
public class PersonaJPARepositoryImpl implements IPersonaJPARepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
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
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		//TypedQuery
		TypedQuery<Persona> miTypedQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula= :datoCedula",Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		//NamedQuery
		Query myQuery=this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	@Override
	//Union de typed y Named
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		//NmedQuery
		TypedQuery<Persona> myQuery=this.entityManager.createNamedQuery("Persona.buscarPorCedula",Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		
		//SQL = SELECT * FROM persona WHERE pers_genero=''
		//Mapeo: JPQL= SELECT p FROM Persona p WHERE p.genero= :datoGenero
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero= :datoGenero");
		jpqlQuery.setParameter("datoGenero", genero);
				
		return jpqlQuery.getResultList();
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
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery=this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido",Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		
		//SQL = SELECT * FROM persona WHERE pers_nombre=''
		//Mapeo: JPQL= SELECT p FROM Persona p WHERE p.nombre= :datoGenero
		Query jpqlQuery=this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre= :datoNombre");
		jpqlQuery.setParameter("datoNombre", nombre);
						
		return jpqlQuery.getResultList();
	}
	
	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		
		Query myQuery = this.entityManager.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		//ExecuteUpdate comando para actualizar o eliminar
		//Devuelve el numero de actualizaciones o eliminaciones que halla echo
		return myQuery.executeUpdate();
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		
		Query myQuery = this.entityManager.createQuery("DELETE Persona p WHERE p.genero = :genero");
		myQuery.setParameter("genero", genero);
		//ExecuteUpdate comando para actualizar o eliminar
		//Devuelve el numero de actualizaciones o eliminaciones que halla echo
		return myQuery.executeUpdate();
	}

}
