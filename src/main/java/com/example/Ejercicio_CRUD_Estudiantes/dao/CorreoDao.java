package com.example.Ejercicio_CRUD_Estudiantes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ejercicio_CRUD_Estudiantes.entities.Correo;

@Repository
public interface CorreoDao extends JpaRepository<Correo, Integer>{

}