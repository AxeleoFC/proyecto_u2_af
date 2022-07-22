package com.uce.edu.demo.tarea22.repository;

import com.uce.edu.demo.tarea22.repository.modelo.Pasaporte;

public interface IPasaporteRepository {
	
	public Pasaporte buscarPorNumero(String numero);
	public void insertar(Pasaporte p);
	public void actualizar(Pasaporte p);
	public void eliminar(String numero);

}
