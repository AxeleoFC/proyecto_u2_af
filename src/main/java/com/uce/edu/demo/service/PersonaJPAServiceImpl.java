package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJPARepository;
import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSensilla;
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
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaTypedNamed(cedula);
	}
	
	//Uso de NativeQuery
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaNative(cedula);
	}

	//Uso de NativeQuery con Named y Typed
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaNamedNative(cedula);
	}
	
	//criteria API
	@Override
	public Persona buscarPorCedulaCriterialAPI(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorCedulaCriterialAPI(cedula);
	}


	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorApellido(apellido);
	}

	@Override
	public List<PersonaSensilla> buscarPorApellidoSensillo(String apellido) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorApellidoSensillo(apellido);
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorNombre(nombre);
	}

	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarPorGenero(genero);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.actualizarPorApellido(genero, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.eliminarPorGenero(genero);
	}

	@Override
	public List<Persona> buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.personaJPARepo.buscarDinamicamente(nombre, apellido, genero);
	}

	@Override
	public List<PersonaContadorGenero> consultarCantidadPorGenero() {
		// TODO Auto-generated method stub
		return this.personaJPARepo.consultarCantidadPorGenero();
	}


}
