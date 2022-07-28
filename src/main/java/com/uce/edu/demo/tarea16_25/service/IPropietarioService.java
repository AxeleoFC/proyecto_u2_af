package com.uce.edu.demo.tarea16_25.service;

import com.uce.edu.demo.tarea16_25.repository.modelo.Propietario;

public interface IPropietarioService {
	public void ingresarPropietario(Propietario p);
	public void eliminarPropietario(String cedula);
	public void actualizarPropietario(Propietario p);
	public Propietario buscarPropietario(String cedula);
}
