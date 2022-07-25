package com.uce.edu.demo.tarea23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea23.repository.IBoletoRepository;
import com.uce.edu.demo.tarea23.repository.IPersonaRepository;
import com.uce.edu.demo.tarea23.repository.modelo.Boleto;
import com.uce.edu.demo.tarea23.repository.modelo.PersonaB;
@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepository personaRepo;
	
	@Autowired
	private IBoletoRepository boletoRepo;
	
	@Override
	public PersonaB buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		PersonaB per=this.personaRepo.buscarPorCedula(cedula);
		per.setBoletos(this.boletoRepo.buscarPorPersona(cedula));
		return per;
	}

	@Override
	public void insertar(PersonaB p) {
		// TODO Auto-generated method stub
		this.personaRepo.insertar(p);
	}

	@Override
	public void actualizar(PersonaB p) {
		// TODO Auto-generated method stub
		this.personaRepo.actualizar(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		PersonaB per=this.buscarPorCedula(cedula);
		for(Boleto b: per.getBoletos()) {
			this.boletoRepo.eliminar(b.getId());
		}
		
		this.personaRepo.eliminar(cedula);
	}

}
