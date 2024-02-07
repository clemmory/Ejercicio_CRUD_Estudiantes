package com.example.Ejercicio_CRUD_Estudiantes.services;

import org.springframework.stereotype.Service;

import com.example.Ejercicio_CRUD_Estudiantes.dao.AlumnoDao;
import com.example.Ejercicio_CRUD_Estudiantes.dao.CorreoDao;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Correo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CorreoServiceImpl implements CorreoService {

    private final CorreoDao correoDao;
    private final AlumnoDao alumnoDao;

    @Override
    public void saveCorreos(Correo correo, int idAlumno) {
       
        correo.setAlumno(alumnoDao.findById(idAlumno).get());
        correoDao.save(correo);
    }

}
