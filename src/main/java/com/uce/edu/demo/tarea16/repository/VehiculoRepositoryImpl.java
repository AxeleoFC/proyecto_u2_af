package com.uce.edu.demo.tarea16.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea16.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void ingresar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.entityManager.persist(v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(placa));
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.entityManager.merge(v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, placa);
	}

}
