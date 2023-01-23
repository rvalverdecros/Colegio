import java.util.ArrayList;

public class Curso {
    // Atributos
    private String nombre;
    private String estado;
    private ArrayList<Alumno> losAlumnos = new ArrayList<Alumno>();
    private ArrayList<Profesor> losProfesores = new ArrayList<Profesor>();

    // Constructor
    Curso(String nombre) {
        this.nombre = nombre;
        this.estado = Actividades.clase;
    }

    // Getters y Setters
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos privados
    private ArrayList<Alumno> mostrarAlumnos() { return losAlumnos; }
    private ArrayList<Profesor> mostrarProfesores() { return losProfesores; }

    // Métodos públicos
    void anadirAlumno(Alumno alumno) { losAlumnos.add(alumno); }
    void borrarAlumno(Alumno alumno){
        losAlumnos.remove(alumno);
    }
    void anadirProfesor(Profesor profesor){
        losProfesores.add(profesor);
    }
    void borrarProfesor(Profesor profesor){
        losProfesores.remove(profesor);
    }

    boolean existeAlumno(Alumno alumno) {
        if (losAlumnos == null) return false;
        return losAlumnos.contains(alumno);
    }
    boolean existeProfesor(Profesor profesor) {
        if (losProfesores == null) return false;
        return losProfesores.contains(profesor);
    }

    public String toString() {
        String listaAlumnos = String.valueOf(mostrarAlumnos());
        String listaProfesores = String.valueOf(mostrarProfesores());
        return "Curso\n" +
                "Nombre del curso: " + nombre + "\n"
                + "Alumnos del curso :" + listaAlumnos + "\n"
                + "Profesores del curso: " + listaProfesores + "\n"
                + "Estado del curso: " + estado;
    }

}
