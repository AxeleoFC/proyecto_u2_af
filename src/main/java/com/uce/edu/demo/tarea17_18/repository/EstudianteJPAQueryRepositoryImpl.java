package com.uce.edu.demo.tarea17_18.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.tarea17_18.repository.modelo.EstudianteQuery;

@Repository
@Transactional
public class EstudianteJPAQueryRepositoryImpl implements IEstudianteJPAQueryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EstudianteQuery buscar(String c) {
		// TODO Auto-generated method stub
		return this.entityManager.find(EstudianteQuery.class, c);
	}

	@Override
	public void insertar(EstudianteQuery e) {
		// TODO Auto-generated method stub
		this.entityManager.persist(e);
	}

	@Override
	public void actualizar(EstudianteQuery e) {
		// TODO Auto-generated method stub
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(c));
	}
	
	//Deber 17

	@Override
	public List<EstudianteQuery> buscarPorFacultad(String facultad) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> miTypedQuery=this.entityManager.createQuery("SELECT e FROM EstudianteQuery e WHERE e.facultad= :datoFacultad",EstudianteQuery.class);
		miTypedQuery.setParameter("datoFacultad", facultad);
		return miTypedQuery.getResultList();
	}

	@Override
	public List<EstudianteQuery> buscarPorCarrera(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> miTypedQuery=this.entityManager.createQuery("SELECT e FROM EstudianteQuery e WHERE e.carrera= :datoCarrera",EstudianteQuery.class);
		miTypedQuery.setParameter("datoCarrera", carrera);
		return miTypedQuery.getResultList();
	}

	@Override
	public EstudianteQuery buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("EstudianteQuery.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (EstudianteQuery) myQuery.getSingleResult();
	}

	@Override
	public List<EstudianteQuery> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createNamedQuery("EstudianteQuery.buscarPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return  myQuery.getResultList();
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> myQuery=this.entityManager.createNamedQuery("EstudianteQuery.buscarPorNombreApellido",EstudianteQuery.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreFacultad(String nombre, String facultad) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> myQuery=this.entityManager.createNamedQuery("EstudianteQuery.buscarPorNombreFacultad",EstudianteQuery.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoFacultad", facultad);
		return myQuery.getResultList();
	}

	
	//Tarea 18
	//NativeQuery
	@Override
	public EstudianteQuery buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante_query WHERE estu_cedula = :datoCedula",
				EstudianteQuery.class);
		myQuery.setParameter("datoCedula", cedula);
		return (EstudianteQuery) myQuery.getSingleResult();
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreNative(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante_query WHERE estu_nombre = :datoNombre",
				EstudianteQuery.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}
	// NamedNativeQuery
	@Override
	public List<EstudianteQuery> buscarPorFacultadCarrera(String facultad, String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> myQuery = this.entityManager.createNamedQuery("EstudianteQuery.buscarPorFacultadCarrera", EstudianteQuery.class);
		myQuery.setParameter("datoFacultad", facultad);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteQuery> buscarPorNombreCarrera(String nombre, String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuery> myQuery = this.entityManager.createNamedQuery("EstudianteQuery.buscarPorNombreCarrera", EstudianteQuery.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoCarrera", carrera);
		return myQuery.getResultList();
	}

}
