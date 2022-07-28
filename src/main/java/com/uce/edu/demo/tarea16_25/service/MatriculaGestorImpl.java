package com.uce.edu.demo.tarea16_25.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.tarea16_25.repository.IMatriculaRepository;
import com.uce.edu.demo.tarea16_25.repository.IPropietarioRepository;
import com.uce.edu.demo.tarea16_25.repository.modelo.Matricula;
import com.uce.edu.demo.tarea16_25.repository.modelo.Propietario;
import com.uce.edu.demo.tarea16_25.repository.modelo.Vehiculo;
@Service
public class MatriculaGestorImpl implements IMatriculaGestorService{
	@Autowired
	private IPropietarioRepository propietarioRepo;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IMatriculaRepository matriculaRepo;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;
	
	@Override
	public void crearMatricula(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro=this.propietarioRepo.buscar(cedula);
		Vehiculo vehi=this.vehiculoService.buscarVehiculo(placa);
		String tipo=vehi.getTipo();
		BigDecimal valorMatricula;
		if(tipo.equals("P")) {
			valorMatricula=this.matriculaServicePesado.calcula(vehi.getPrecio());
		}else {
			valorMatricula=this.matriculaServiceLiviano.calcula(vehi.getPrecio());
		}
		
		if(vehi.getPrecio().doubleValue()>2000) {
			valorMatricula=valorMatricula.subtract(valorMatricula.multiply(new BigDecimal(0.07).setScale(2, RoundingMode.HALF_UP)));
		}
		
		Matricula matricula=new Matricula();
		matricula.setFechaMatriculacion(LocalDateTime.now());
		//matricula.setVehiculo(vehi);
		matricula.setVehiculo(vehi);
		//matricula.setPropietario(pro);
		matricula.setPropietario(pro);
		matricula.setPrecioMatriculacion(valorMatricula);
		this.matriculaRepo.ingresar(matricula);
	}

}
