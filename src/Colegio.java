import java.util.ArrayList;

public class Colegio {
    // Atributos
    private String nombre;
     ArrayList<Aula> aulas = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
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

    public Profesor getProfesor (String DNI) {
        Profesor profesorAModificar = null;

        for (Profesor profesor: profesores) {
            if (profesor.dni == DNI) profesorAModificar = profesor;
        }
        return profesorAModificar;
    }
}