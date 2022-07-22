package com.uce.edu.demo.tarea22.service;

import com.uce.edu.demo.tarea22.repository.modelo.Pasaporte;

public interface IPasaporteService {
	
	public Pasaporte buscarPorNumero(String numero);
	public void insertar(Pasaporte p);
	public void actualizar(Pasaporte p);
	public void eliminar(String numero);

}
