package com.uce.edu.demo.cajero.repository;

import com.uce.edu.demo.cajero.repository.modelo.Factura;

public interface IFacturaRepository {
	
	public void ingresar(Factura f);
	public Factura consultar(Integer id);
}
