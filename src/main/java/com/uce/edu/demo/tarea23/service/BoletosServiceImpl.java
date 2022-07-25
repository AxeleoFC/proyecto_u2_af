package com.uce.edu.demo.tarea23.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea23.repository.IBoletoRepository;
import com.uce.edu.demo.tarea23.repository.modelo.Boleto;
@Service
public class BoletosServiceImpl implements IBoletosService {

	@Autowired
	private IBoletoRepository boletoRepo;
	
	@Override
	public List<Boleto> buscarPorPersona(String cedula) {
		// TODO Auto-generated method stub
		return this.boletoRepo.buscarPorPersona(cedula);
	}

	@Override
	public void insertar(Boleto b) {
		// TODO Auto-generated method stub
		this.boletoRepo.insertar(b);
	}

	@Override
	public Boleto buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.boletoRepo.buscarPorId(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.boletoRepo.eliminar(id);
	}

}
