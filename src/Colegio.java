import java.util.ArrayList;
import java.util.Objects;

public class Colegio {
    // Atributos
    private String nombre;
     ArrayList<Aula> aulas = new ArrayList<>();
     ArrayList<Curso> cursos = new ArrayList<>();
     ArrayList<Alumno> alumnos = new ArrayList<>();
     ArrayList<Profesor> profesores = new ArrayList<>();
    private Direccion direccion = new Direccion(3);

    // Constructor
    public Colegio(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    void anadirAula (Aula aula) { aulas.add(aula); }
    void anadirCurso (Curso curso) { cursos.add(curso); }
    void anadirAlumno (Alumno alumno) { alumnos.add(alumno); }
    void anadirProfesor (Profesor profesor) { profesores.add(profesor); }

    String mostrarAula () {
        StringBuilder aulasAMostrar = new StringBuilder();
        for (Aula aula : aulas) {
            aulasAMostrar.append(aula);
            aulasAMostrar.append("\n");
        }
        return aulasAMostrar.toString();
    }
    String mostrarCurso () {
        StringBuilder cursosAMostrar = new StringBuilder();
        for (Curso curso : cursos) {
            cursosAMostrar.append(curso.toString());
            cursosAMostrar.append("\n");
        }
        return cursosAMostrar.toString();
    }
    String mostrarAlumno () {
        StringBuilder alumnosAMostrar = new StringBuilder();
        for (Alumno alumno : alumnos) {
            alumnosAMostrar.append(alumno);
            alumnosAMostrar.append("\n");
        }
        return alumnosAMostrar.toString();
    }
    String mostrarProfesor () {
        StringBuilder profesoresAMostrar = new StringBuilder();
        for (Profesor profesor : profesores) {
            profesoresAMostrar.append(profesor);
            profesoresAMostrar.append("\n");
        }
        return profesoresAMostrar.toString();
    }
    void eliminarAula(int numero) { aulas.remove(numero); }
    void eliminarCurso(int numero) { cursos.remove(numero); }
    void eliminarAlumnos(int numero) {
        Alumno alumno = alumnos.get(numero);

        for (Curso curso : cursos) {
            if (curso.existeAlumno(alumno)){
                curso.borrarAlumno(alumno);
            }
        }

        alumnos.remove(alumno);
    }
    void eliminarProfesores(int numero){
        profesores.remove(numero);
    }

    public Profesor getProfesor (String DNI) {
        Profesor profesorAModificar = null;

        for (Profesor profesor: profesores) {
            if (profesor.dni == DNI) profesorAModificar = profesor;
        }
        return profesorAModificar;
    }

    public Alumno getAlumno (String DNI) {
        Alumno alumnoAModificar = null;

        for (Alumno alumno: alumnos) {
            if (Objects.equals(alumno.dni, DNI)) alumnoAModificar = alumno;
        }
        return alumnoAModificar;
    }
}