package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Persona;
import com.uce.edu.demo.repository.IPersonaJDBCRepository;
@Service
public class PersonaJDBCServiceImpl implements IPersonaJDBCService {

	@Autowired
	private IPersonaJDBCRepository personaJDBCRepo;
	
	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.actualizar(p);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.eliminar(id);
	}

	@Override
	public Persona buscar(int id) {
		// TODO Auto-generated method stub
		return this.personaJDBCRepo.buscarPorId(id);
	}

}
