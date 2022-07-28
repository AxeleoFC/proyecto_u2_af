package com.uce.edu.demo.tarea16_25.repository;

import com.uce.edu.demo.tarea16_25.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	public void ingresar(Vehiculo v);
	public void eliminar(String placa);
	public void actualizar(Vehiculo v);
	public Vehiculo buscar(String placa);
}
