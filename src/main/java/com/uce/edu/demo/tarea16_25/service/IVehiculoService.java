package com.uce.edu.demo.tarea16_25.service;

import com.uce.edu.demo.tarea16_25.repository.modelo.Vehiculo;

public interface IVehiculoService {
	public void ingresarVehiculo(Vehiculo v);
	public void eliminarVehiculo(String placa);
	public void actualizarVehiculo(Vehiculo v);
	public Vehiculo buscarVehiculo(String placa);
}
