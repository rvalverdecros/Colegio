import java.util.ArrayList;

public class Curso {

    private String nombre;

    private String estado;

    private ArrayList<Alumno> lisAlumnos;
    private ArrayList<Profesor> lisProfesores;

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

    Curso(String nombre) {
        this.nombre = nombre;
    }

    private String mostrarAlumnos(){
        String res = "";
        for (int i = 0; i< lisAlumnos.size(); i++){
            res = lisAlumnos.get(i).toString();
        }
        return res;
    }

    private String mostrarProfesores(){
        String res = "";
        for (int i = 0; i< lisProfesores.size(); i++){
            res = lisProfesores.get(i).toString();
        }
        return res;
    }

    public String toString() {
        return "Curso\n" +
                "Nombre del curso: " + nombre + "\n"
                + "Alumnos del curso :" + mostrarAlumnos() + "\n"
                + "Profesores del curso: " + mostrarProfesores() + "\n"
                + "Estado del curso: " + estado;
    }

}
