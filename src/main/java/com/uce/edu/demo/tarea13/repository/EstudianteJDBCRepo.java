package com.uce.edu.demo.tarea13.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.tarea13.modelo.Estudiante;
@Repository
public class EstudianteJDBCRepo implements IEstudianteJDBCRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Estudiante buscar(String c) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE cedula=?",
				new Object[] {c},
				new BeanPropertyRowMapper<Estudiante>(Estudiante.class));
	}

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("INSERT INTO estudiante(cedula, nombre, apellido, facultad, carrera) VALUES (?, ?, ?, ?, ?)", 
				new Object[] {e.getCedula(), e.getNombre(), e.getApellido(), e.getFacultad(), e.getCarrera()});
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("UPDATE estudiante SET nombre=?, apellido=?, facultad=?, carrera=? WHERE cedula=?", 
				new Object[] {e.getNombre(), e.getApellido(), e.getFacultad(), e.getCarrera(), e.getCedula()});
	}

	@Override
	public void eliminar(String c) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("DELETE FROM estudiante WHERE (cedula=?)", 
				new Object[] {c});
	}

}
