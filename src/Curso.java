import java.util.ArrayList;

public class Curso {
    // Atributos
    private String nombre;
    private String estado;
    private ArrayList<Alumno> lisAlumnos;
    private ArrayList<Profesor> lisProfesores;

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
    private String mostrarAlumnos(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lisAlumnos.size(); i++){
            res.append(lisAlumnos.get(i).toString());
            res.append("\n");
        }
        return res.toString();
    }

    private String mostrarProfesores(){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i< lisProfesores.size(); i++){
            res.append(lisProfesores.get(i).toString());
            res.append("\n");
        }
        return res.toString();
    }

    // Métodos públicos
    void anadirAlumno(Alumno alumno){
        lisAlumnos.add(alumno);
    }

    void borrarAlumno(Alumno alumno){
        lisAlumnos.remove(alumno);
    }

    void anadirProfesor(Profesor profesor){
        lisProfesores.add(profesor);
    }

    void borrarProfesor(Profesor profesor){
        lisProfesores.remove(profesor);
    }

    public String toString() {
        return "Curso\n" +
                "Nombre del curso: " + nombre + "\n"
                + "Alumnos del curso :" + mostrarAlumnos() + "\n"
                + "Profesores del curso: " + mostrarProfesores() + "\n"
                + "Estado del curso: " + estado;
    }

}
