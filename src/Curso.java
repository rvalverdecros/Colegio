import java.util.ArrayList;

public class Curso {
    // Atributos
	private int id;
    private String nombre;
    private String estado;
    private int alumnos;
    private ArrayList<Alumno> losAlumnos = new ArrayList<Alumno>();
    private ArrayList<Profesor> losProfesores = new ArrayList<Profesor>();
    private TestConex testConex = new TestConex();

    // Constructor
    Curso(String nombre) {
        this.nombre = nombre;
        this.estado = Actividades.clase;
    }
    
    Curso(int id,String nombre, String estado, int alumnos){
    	this.id = id;
    	this.nombre = nombre;
    	this.estado = estado;
    	this.alumnos = alumnos;
    }
    // Getters y Setters
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
        testConex.setEstadoCurso(id,estado);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        testConex.setNombreCurso(id,nombre);
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public void setalumnos(int alumnos) {
        this.alumnos = alumnos;
        testConex.setAlumnosCurso(id,alumnos);
    }
    
    public int getalumnos() {
        return alumnos;
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
        "ID:" + id + "\n"
		+"Nombre del curso: " + nombre + "\n"
                + "Alumnos del curso :" + listaAlumnos + "\n"
                + "Profesores del curso: " + listaProfesores + "\n"
                + "Estado del curso: " + estado;
    }

}
