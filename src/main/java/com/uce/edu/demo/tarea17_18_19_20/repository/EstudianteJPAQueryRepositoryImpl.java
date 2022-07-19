package com.uce.edu.demo.tarea17_18_19_20.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuery;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQueryPorCarrera;
import com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuerySencillo;

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

	//Tarea 19
	@Override
	public List<EstudianteQuery> buscarNombreApellidoCriteriaAPI(String nombre, String apellido) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EstudianteQuery> myQuery = myCriteria.createQuery(EstudianteQuery.class);
		
		Root<EstudianteQuery> myTabla=myQuery.from(EstudianteQuery.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		
		Predicate predicadoFinal=myCriteria.and(predicadoNombre, predicadoApellido);
		
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<EstudianteQuery> myQueryFinal=this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public List<EstudianteQuery> buscarDinamicamenteNombreApellidoFacultatCarrera(String nombre, String apellido,
			String facultada, String carrera) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EstudianteQuery> myQuery = myCriteria.createQuery(EstudianteQuery.class);
		
		Root<EstudianteQuery> myTabla=myQuery.from(EstudianteQuery.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoFacultad=myCriteria.equal(myTabla.get("facultad"), facultada);
		Predicate predicadoCarrera=myCriteria.equal(myTabla.get("carrera"), carrera);
		
		Predicate predicadoFinal=null;
		if(facultada.equals("Ingenieria en ciencias aplicadas.")) {
			//Si es de Ingenieria en ciencias aplicada, se busca a los estudiantes
			//con el nombre y apellidos iguales al parametro
			//o puede ser de la carrera dada por el parametro
			predicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			predicadoFinal = myCriteria.or(predicadoFinal, predicadoCarrera);
			predicadoFinal = myCriteria.and(predicadoFinal, predicadoFacultad);
		}else if(facultada.equals("Medicina")){
			//Si es de Medicina, se busca a los estudiantes
			//con el nombre o apellidos iguales al parametro
			//y puede ser de la carrera dada por el parametro
			predicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
			predicadoFinal = myCriteria.and(predicadoFinal, predicadoCarrera);
			predicadoFinal = myCriteria.and(predicadoFinal, predicadoFacultad);
		}
		
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<EstudianteQuery> myQueryFinal=this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	//Tarea 20
	@Override
	public List<EstudianteQuerySencillo> buscarPorCarreraSencillo(String carrera) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQuerySencillo> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQuerySencillo(e.nombre, e.carrera) "
				+ "FROM EstudianteQuery e "
				+ "WHERE e.carrera= :datoCarrera",
				EstudianteQuerySencillo.class);
		myQueri.setParameter("datoCarrera", carrera);
		return myQueri.getResultList();
	}

	@Override
	public List<EstudianteQueryPorCarrera> consultarEstudiantesPorCarrera(String facultad) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteQueryPorCarrera> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.tarea17_18_19_20.repository.modelo.EstudianteQueryPorCarrera(e.carrera, COUNT(e.carrera)) "
				+ "FROM EstudianteQuery e "
				+ "WHERE e.facultad= :datoFacultad "
				+ "GROUP BY e.carrera",
				EstudianteQueryPorCarrera.class);
		myQueri.setParameter("datoFacultad", facultad);
		return myQueri.getResultList();
	}

}
