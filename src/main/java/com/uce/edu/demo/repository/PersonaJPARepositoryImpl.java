package com.uce.edu.demo.repository;

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

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSensilla;
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

	//Uso de NativeQuery
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		//No se usa sentencias JPQL
		//Aqqui usamos SQL puro
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :datoCedula",
				Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	//Uso de NativeQuery con Named
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		//Se usa igual que un Named pero tener en cuenta que se usa SQL y no JPQL
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	//Criterial APi
	@Override
	public Persona buscarPorCedulaCriterialAPI(String cedula) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myBuilder=this.entityManager.getCriteriaBuilder();
		
		// Transforma un CriteriaBuilder a un CriteriaQuery de tipo Persona
		CriteriaQuery<Persona> myQuery=myBuilder.createQuery(Persona.class);
		
		//Aqui se empieza la sentencia SQL
		// Root FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class);//FROM persona
		
		//Hace root a personaRoot, 
		//La parte del WHERE es para pasar los parametros que deseamos comparar
		//--->myQuery.select(personaRoot).where(myBuilder.equal(personaRoot.get("cedula"), cedula)); esto devuelve la sentencia
		
		//(myQuery.select(personaRoot) Select * from persona
		//Las condiciones WHERE en CRITERI API se los conoce como predicados
		Predicate p1=myBuilder.equal(personaFrom.get("cedula"), cedula);//p.cedula = :datoCedula
		
		//CriteriaQuery<Persona> myQueryCompleto = myQuery.select(personaFrom).where(p1);
		myQuery.select(personaFrom).where(p1);
		//Finalizado my query completo
		
		//TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQuery.select(personaFrom).where(myBuilder.equal(personaFrom.get("cedula"), cedula)));
		TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}
	
	//Criteria API
	//Buscar con un if/ si es hombre teine que tener el nombre y apellido igual
	//si es mujer puede tener el nombre o el apellido igual
	@Override
	public List<Persona> buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);
		
		Root<Persona> myTabla=myQuery.from(Persona.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);// p.nombre = :datoNombre
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);// p.apellido = :datoApellido
		
		Predicate predicadoFinal=null;
		if(genero.equals("M")) {
			// p.nombre = :datoNombre and p.apellido = :datoApellido
			predicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
		}else if(genero.equals("F")){
			// p.nombre = :datoNombre or p.apellido = :datoApellido
			predicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}
	
	public List<Persona> buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);
		
		Root<Persona> myTabla=myQuery.from(Persona.class);
		
		Predicate predicadoNombre=myCriteria.equal(myTabla.get("nombre"), nombre);// p.nombre = :datoNombre
		Predicate predicadoApellido=myCriteria.equal(myTabla.get("apellido"), apellido);// p.apellido = :datoApellido
		Predicate predicadogenero=myCriteria.equal(myTabla.get("genero"), genero);// p.genero = :datoGenero
		
		Predicate predicadoFinal=null;
		if(genero.equals("M")) {
			predicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
			predicadoFinal = myCriteria.and(predicadoFinal, predicadogenero);
		}else if(genero.equals("F")){
			predicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
			predicadoFinal = myCriteria.and(predicadoFinal, predicadogenero);
		}
		myQuery.select(myTabla).where(predicadoFinal);
		
		TypedQuery<Persona> myQueryFinal=this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
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
	
	// Uso de DTO
	@Override
	public List<PersonaSensilla> buscarPorApellidoSensillo(String apellido) {
		// TODO Auto-generated method stub
		
		//Hacer referencia del objeto PersonaSensila con la referencia de su ubicacion
		//com.uce.edu.demo.repository.modelo.PersonaSensilla
		TypedQuery<PersonaSensilla> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaSensilla(p.nombre, p.apellido) FROM Persona p WHERE p.apellido= :datoApellido",
				PersonaSensilla.class);
		myQueri.setParameter("datoApellido", apellido);
		return myQueri.getResultList();
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub

		TypedQuery<PersonaContadorGenero> myQueri = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.PersonaContadorGenero(p.genero, COUNT(p.genero)) "
				+ "FROM Persona p "
				+ "GROUP BY p.genero",
				PersonaContadorGenero.class);
		return myQueri.getResultList();
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
