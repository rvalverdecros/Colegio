import java.util.ArrayList;

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

    void mostrarAula (){
        for (int i = 0; i < aulas.size(); i++){
            System.out.println(aulas.get(i).toString());
        }
    }
    void mostrarCurso (){
        for (int i = 0; i < cursos.size(); i++){
            System.out.println(cursos.get(i).toString());
        }
    }

    void mostrarAlumno (){
        for (int i = 0; i < alumnos.size(); i++){
            System.out.println(alumnos.get(i).toString());
        }
    }

    void mostrarProfesor (){
        for (int i = 0; i < profesores.size(); i++){
            System.out.println(profesores.get(i).toString());
        }
    }

    void eliminarAula(int numero){
        aulas.remove(numero);
    }

    void eliminarCurso(int numero){
        cursos.remove(numero);
    }

    void eliminarAlumnos(int numero){
        alumnos.remove(numero);
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
}