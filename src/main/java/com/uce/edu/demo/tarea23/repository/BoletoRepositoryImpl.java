package com.uce.edu.demo.tarea23.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea23.repository.modelo.Boleto;
@Repository
@Transactional
public class BoletoRepositoryImpl implements IBoletoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Boleto> buscarPorPersona(String cedula) {
		// TODO Auto-generated method stub
		
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM boleto WHERE pers_id_boleto = :datoCedula",
				Boleto.class);
		myQuery.setParameter("datoCedula", cedula);
		
		return myQuery.getResultList();
	}

	@Override
	public void insertar(Boleto b) {
		// TODO Auto-generated method stub
		this.entityManager.persist(b);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public Boleto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Boleto.class, id);
	}
}
