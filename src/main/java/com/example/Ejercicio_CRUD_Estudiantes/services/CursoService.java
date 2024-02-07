package com.example.Ejercicio_CRUD_Estudiantes.services;

import java.util.List;

import com.example.Ejercicio_CRUD_Estudiantes.entities.Curso;

public interface CursoService {

    public List<Curso> getCursos();
    public Curso getCurso(int idCurso);
    public void saveCurso(Curso curso);


}
