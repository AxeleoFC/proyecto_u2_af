package com.uce.edu.demo.tarea22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea22.repository.IPasaporteRepository;
import com.uce.edu.demo.tarea22.repository.modelo.Pasaporte;
@Service
public class PasaporteServiceImpl implements IPasaporteService {

	@Autowired
	private IPasaporteRepository pasaporteRepo;
	
	@Override
	public Pasaporte buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.pasaporteRepo.buscarPorNumero(numero);
	}

	@Override
	public void insertar(Pasaporte p) {
		// TODO Auto-generated method stub
		this.pasaporteRepo.insertar(p);
	}

	@Override
	public void actualizar(Pasaporte p) {
		// TODO Auto-generated method stub
		this.pasaporteRepo.actualizar(p);
	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.pasaporteRepo.eliminar(numero);
	}

}
