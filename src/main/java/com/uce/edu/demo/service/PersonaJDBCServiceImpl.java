package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJDBCRepository;
import com.uce.edu.demo.to.PersonaTo;
@Service
public class PersonaJDBCServiceImpl implements IPersonaJDBCService {

	@Autowired
	private IPersonaJDBCRepository personaJDBCRepo;
	
	@Override
	public void guardar(PersonaTo p) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.insertar(p);
	}

	@Override
	public void actualizar(PersonaTo p) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.actualizar(p);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.personaJDBCRepo.eliminar(id);
	}

	@Override
	public PersonaTo buscar(int id) {
		// TODO Auto-generated method stub
		return this.personaJDBCRepo.buscarPorId(id);
	}

	@Override
	public List<PersonaTo> buscarTodos() {
		// TODO Auto-generated method stub
		return this.personaJDBCRepo.buscarTodos();
	}

}
