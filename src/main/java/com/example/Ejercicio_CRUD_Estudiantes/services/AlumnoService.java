package com.example.Ejercicio_CRUD_Estudiantes.services;

import java.util.List;

import com.example.Ejercicio_CRUD_Estudiantes.entities.Alumno;

public interface AlumnoService {

    public List<Alumno> getAlumnos(); 
    public Alumno getAlumno(int idAlumno);
    public void saveAlumno(Alumno alumno);
    public void modifyAlumno(Alumno alumno);   
    public void deleteAlumno(int idAlumno);
}
