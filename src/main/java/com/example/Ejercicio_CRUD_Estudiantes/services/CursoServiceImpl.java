package com.example.Ejercicio_CRUD_Estudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Ejercicio_CRUD_Estudiantes.dao.CursoDao;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Curso;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService{

    private final CursoDao cursoDao;

    @Override
    public List<Curso> getCursos() {
        return cursoDao.findAll();
    }

    @Override
    public Curso getCurso(int idCurso) {
        return cursoDao.findById(idCurso).get();
    }

    @Override
    public void saveCurso(Curso curso) {
        cursoDao.save(curso);
    }

}
