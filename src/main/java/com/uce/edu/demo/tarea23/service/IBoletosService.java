package com.uce.edu.demo.tarea23.service;

import java.util.List;

import com.uce.edu.demo.tarea23.repository.modelo.Boleto;

public interface IBoletosService {
	
	public List<Boleto> buscarPorPersona(String cedula);
	public Boleto buscarPorId(Integer id);
	public void insertar(Boleto b);
	public void eliminar(Integer id);

}
