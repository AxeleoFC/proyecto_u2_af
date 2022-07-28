package com.uce.edu.demo.tarea16_25.repository;

import com.uce.edu.demo.tarea16_25.repository.modelo.Propietario;

public interface IPropietarioRepository {
	public void ingresar(Propietario p);
	public void eliminar(String cedula);
	public void actualizar(Propietario p);
	public Propietario buscar(String cedula);

}
