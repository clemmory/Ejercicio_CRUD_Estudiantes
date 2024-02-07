package com.example.Ejercicio_CRUD_Estudiantes.services;

import org.springframework.stereotype.Service;

import com.example.Ejercicio_CRUD_Estudiantes.dao.AlumnoDao;
import com.example.Ejercicio_CRUD_Estudiantes.dao.TelefonoDao;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Telefono;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class TelefonoServiceImpl implements TelefonoService {

    private final TelefonoDao telefonoDao;
    private final AlumnoDao alumnoDao;

    @Override
    public void saveTelefonos(Telefono telefono, int idAlumno) {
       telefono.setAlumno(alumnoDao.findById(idAlumno).get());
       telefonoDao.save(telefono);
    }

}
