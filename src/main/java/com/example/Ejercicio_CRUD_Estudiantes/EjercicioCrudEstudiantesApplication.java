package com.example.Ejercicio_CRUD_Estudiantes;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Ejercicio_CRUD_Estudiantes.entities.Alumno;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Correo;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Curso;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Genero;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Horario;
import com.example.Ejercicio_CRUD_Estudiantes.entities.Telefono;
import com.example.Ejercicio_CRUD_Estudiantes.services.AlumnoService;
import com.example.Ejercicio_CRUD_Estudiantes.services.CorreoService;
import com.example.Ejercicio_CRUD_Estudiantes.services.CursoService;
import com.example.Ejercicio_CRUD_Estudiantes.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor

public class EjercicioCrudEstudiantesApplication implements CommandLineRunner{

	private final CursoService cursoService;
	private final AlumnoService alumnoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioCrudEstudiantesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Create Cursos
		Curso curso1 = Curso.builder()
			.descripcion("Agile")
			.horario(Horario.DIURNO)
			.build();

		Curso curso2 = Curso.builder()
			.descripcion("Java")
			.horario(Horario.NOCTURNO)
			.build();

		Curso curso3 = Curso.builder()
			.descripcion("English")
			.horario(Horario.DIURNO)
			.build();

		cursoService.saveCurso(curso1);
		cursoService.saveCurso(curso2);
		cursoService.saveCurso(curso3);


		//Create Alumnos
		Alumno alumno1 = Alumno.builder()
			.nombre("Clementine")
			.apellidos("Esquer, Mory")
			.genero(Genero.MUJER)
			.fechaDeMatricula(LocalDate.of(2014, Month.APRIL,12))
			.totalAsignaturas(3)
			.foto("foto1")
			.curso(cursoService.getCurso(1))
			.build();
		
		Alumno alumno2 = Alumno.builder()
			.nombre("Jose")
			.apellidos("Molina, Belles")
			.genero(Genero.HOMBRE)
			.fechaDeMatricula(LocalDate.of(2021, Month.FEBRUARY,5))
			.totalAsignaturas(2)
			.foto("foto2")
			.curso(cursoService.getCurso(2))
			.build();
		
		Alumno alumno3 = Alumno.builder()
			.nombre("Clara")
			.apellidos("Monti, Lespes")
			.genero(Genero.MUJER)
			.fechaDeMatricula(LocalDate.of(2010, Month.MARCH,15))
			.totalAsignaturas(2)
			.foto("foto3")
			.curso(cursoService.getCurso(2))
			.build();

		Alumno alumno4 = Alumno.builder()
			.nombre("Leo")
			.apellidos("Poty, Portafaix")
			.genero(Genero.HOMBRE)
			.fechaDeMatricula(LocalDate.of(2022, Month.APRIL,21))
			.totalAsignaturas(3)
			.foto("foto4")
			.curso(cursoService.getCurso(1))
			.build();
		
		Alumno alumno5 = Alumno.builder()
			.nombre("Sandra")
			.apellidos("Serge, Gandia")
			.genero(Genero.MUJER)
			.fechaDeMatricula(LocalDate.of(2014, Month.SEPTEMBER,10))
			.totalAsignaturas(3)
			.foto("foto5")
			.curso(cursoService.getCurso(3))
			.build();
		
		Alumno alumno6 = Alumno.builder()
			.nombre("Miguel")
			.apellidos("Cortes, Angel")
			.genero(Genero.MUJER)
			.fechaDeMatricula(LocalDate.of(2017, Month.OCTOBER,9))
			.totalAsignaturas(3)
			.foto("foto6")
			.curso(cursoService.getCurso(3))
			.build();

		alumnoService.saveAlumno(alumno1);
		alumnoService.saveAlumno(alumno2);
		alumnoService.saveAlumno(alumno3);
		alumnoService.saveAlumno(alumno4);
		alumnoService.saveAlumno(alumno5);
		alumnoService.saveAlumno(alumno6);

		Telefono telefono1 = Telefono.builder()
			.numeros("634527789")
			.alumno(alumnoService.getAlumno(1))
			.build();
	
		telefonoService.saveTelefonos(telefono1, 1);

		Correo correo1 = Correo.builder()
			.correo("clementine.mory@gmail.com")
			.alumno(alumnoService.getAlumno(1))
			.build();
		
		correoService.saveCorreos(correo1, 1);
		



	}

}
