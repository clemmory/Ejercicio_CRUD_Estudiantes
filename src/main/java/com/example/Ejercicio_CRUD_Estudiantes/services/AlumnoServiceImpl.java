package com.example.Ejercicio_CRUD_Estudiantes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Ejercicio_CRUD_Estudiantes.dao.AlumnoDao;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Alumno;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDao alumnoDao;

    @Override
    public List<Alumno> getAlumnos() {
        return alumnoDao.findAll();
    }

    @Override
    public Alumno getAlumno(int idAlumno) {
        return alumnoDao.findById(idAlumno).get();
    }

    @Override
    public void saveAlumno(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    public void modifyAlumno(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    public void deleteAlumno(int idAlumno) {
        alumnoDao.deleteById(idAlumno);
    }


}
