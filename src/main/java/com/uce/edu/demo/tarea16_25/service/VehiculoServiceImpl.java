package com.uce.edu.demo.tarea16_25.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea16_25.repository.IVehiculoRepository;
import com.uce.edu.demo.tarea16_25.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoRepository vehiculoRepo;

	@Override
	public void ingresarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.ingresar(v);
	}

	@Override
	public void eliminarVehiculo(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.eliminar(placa);
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.actualizar(v);
	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscar(placa);
	}

}
