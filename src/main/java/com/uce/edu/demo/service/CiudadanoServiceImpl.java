package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoRepository;
import com.uce.edu.demo.repository.modelo.CiudadanoT;
@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
	
	@Autowired
	private ICiudadanoRepository ciudadanoRepo;

	@Override
	public void ingresarCiudadano(CiudadanoT c) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.ingresar(c);
	}

}
