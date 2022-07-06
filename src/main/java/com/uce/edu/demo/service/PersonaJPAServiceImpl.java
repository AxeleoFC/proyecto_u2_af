package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJPARepository;
import com.uce.edu.demo.repository.modelo.Persona;
@Service
public class PersonaJPAServiceImpl implements IPersonaJPAService {

	@Autowired
	private IPersonaJPARepository personaJPARepo;
	
	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJPARepo.insertar(p);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJPARepo.actualizar(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.personaJPARepo.eliminar(id);
	}

	@Override
	public Persona buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorId(id);
	}

	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedula(cedula);
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorApellido(apellido);
	}

}
