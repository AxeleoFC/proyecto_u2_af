package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Persona;

@Repository
public class PersonaJDBCRepositoryImpl implements IPersonaJDBCRepository {
	
	//Forma para conectarse a la BD con jdbc
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Persona buscarPorId(int id) {
		// TODO Auto-generated method stub
		//Forma para buscar una persona con JDBC
		return this.jdbcTemplate.queryForObject("SELECT * FROM persona WHERE id=?",
				new Object[] {id},
				new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public void insertar(Persona p) {
		// TODO Auto-generated method stub
		//Forma para insertar con jdbc
		this.jdbcTemplate.update("INSERT INTO persona(id, nombre, apellido) VALUES (?, ?, ?)", 
				new Object[] {p.getId(), p.getNombre(), p.getApellido()});
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		//Forma para actualizar con jdbc
		this.jdbcTemplate.update("UPDATE persona SET nombre=?, apellido=? WHERE id=?", 
				new Object[] {p.getNombre(), p.getApellido(), p.getId()});
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		//Forma para actualizar con jdbc
		this.jdbcTemplate.update("DELETE FROM persona WHERE (id=?)", 
				new Object[] {id});
	}



}
