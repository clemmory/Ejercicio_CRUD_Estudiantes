package com.example.Ejercicio_CRUD_Estudiantes.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Ejercicio_CRUD_Estudiantes.entities.Alumno;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Correo;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Curso;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Horario;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Telefono;
import com.example.Ejercicio_CRUD_Estudiantes.services.AlumnoService;
import com.example.Ejercicio_CRUD_Estudiantes.services.CursoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor

public class MainController {

    private final AlumnoService alumnoService;
    private final CursoService cursoService;

    @GetMapping("/all")
    public String giveAllStudents(Model model) {
        model.addAttribute("alumnos", alumnoService.getAlumnos());
        return "views/listadoAlumnos";
    }

    @GetMapping("/formularioAlta")
    public String formularioAltaModif(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", cursoService.getCursos());
        return "views/formulario";
    }

    @PostMapping("/saveAlumno")
    @Transactional
    public String saveAlumno(@ModelAttribute(name = "alumno") Alumno alumno,
            @RequestParam(name = "phoneNumber", required = false) String telefonosRecibidos,
            @RequestParam(name = "email", required = false) String correosRecibidos) {

        if (telefonosRecibidos != null) {
            String[] arrayTelefonos = telefonosRecibidos.split(";");
            List<String> numerosTelefonos = Arrays.asList(arrayTelefonos);

            List<Telefono> telefonos = new ArrayList<>();
            numerosTelefonos.stream()
                    .forEach(numeroTelefono -> {
                        telefonos.add(
                                Telefono.builder()
                                        .numeros(numeroTelefono)
                                        .alumno(alumno)
                                        .build());
                    });
            alumno.setTelefonos(telefonos);
        }

        if (correosRecibidos != null) {
            String[] arrayCorreos = correosRecibidos.split(";");
            List<String> correosList = Arrays.asList(arrayCorreos);

            List<Correo> correos = new ArrayList<>();
            correosList.stream()
                    .forEach(correo -> {
                        correos.add(
                                Correo.builder()
                                        .correo(correo)
                                        .alumno(alumno)
                                        .build());
                    });
            alumno.setCorreos(correos);
        }

        alumnoService.saveAlumno(alumno);
        return "redirect:/all";

    }

    @GetMapping("/deleteAlumno/{id}")
    public String deleteAlumno(@PathVariable(name = "id", required = true) int idAlumno) {
        alumnoService.deleteAlumno(idAlumno);
        return "redirect:/all";
    }

    @GetMapping("/actualizar/{id}")
    @Transactional
    public String editAlumno(@PathVariable(name = "id", required = true) int idAlumno, Model model) {

        Alumno alumno = alumnoService.getAlumno(idAlumno);
        model.addAttribute("alumno", alumno);

        List<Curso> cursos = cursoService.getCursos();
        model.addAttribute("cursos", cursos);

        if (alumno.getTelefonos() != null) {
            String telefonos = alumno.getTelefonos().stream()
                    .map(Telefono::getNumeros)
                    .collect(Collectors.joining(" ; "));

            model.addAttribute("telefonos", telefonos);
        }
        if (alumno.getCorreos() != null) {
            String correos = alumno.getCorreos().stream()
                    .map(Correo::getCorreo)
                    .collect(Collectors.joining(" ; "));
            model.addAttribute("correos", correos);
        }

        return "views/formulario";
    }

    @GetMapping("/listadoHorario")
    public String getAlumnosMañana(Model model){

        List<Curso> cursos = cursoService.getCursos().stream()
            .filter(c -> c.getHorario().equals(Horario.DIURNO))
            .collect(Collectors.toList());

        model.addAttribute("cursos", cursos);
     
        List<List<Alumno>> alumnos = cursoService.getCursos().stream()
            .map(c -> c.getAlumnos())
            .collect(Collectors.toList());

        model.addAttribute("alumnos", alumnos);
        
        return "views/listMorning";
    }
}
