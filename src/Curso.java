import java.util.ArrayList;

public class Curso {
    // Atributos
	private int id;
    private String nombre;
    private String estado;
    private int alumnos;
    private ArrayList<Alumno> lisAlumnos = new ArrayList<>();
    private ArrayList<Profesor> lisProfesores = new ArrayList<>();
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
    private ArrayList<Alumno> mostrarAlumnos() {
        return testConex.selectAlumnosByIDCurso(getID());
    }
    private ArrayList<Profesor> mostrarProfesores() { return testConex.selectProfesoresByIDCurso(getID()); }

    // Métodos públicos
    void anadirAlumno(Alumno alumno) {
        //losAlumnos.add(alumno);
        testConex.setCursoAlumno(alumno.getID(),getID());
    }
    void borrarAlumno(Alumno alumno){
        //losAlumnos.remove(alumno);
        testConex.setCursoAlumnoNull(alumno.getID());
    }
    void anadirProfesor(Profesor profesor){
        //losProfesores.add(profesor);
        testConex.setCursoProfesor(profesor.getID(),getID());
    }
    void borrarProfesor(Profesor profesor){

        //losProfesores.remove(profesor);
        testConex.setCursoProfesorNull(profesor.getID());
    }

    boolean existeAlumno(Alumno alumno) {
        lisAlumnos = mostrarAlumnos();
        if (lisAlumnos == null) return false;

        boolean encontrado = false;

        for (Alumno alumno1 : lisAlumnos){
            if (alumno1.getID() == alumno.getID()){
                encontrado = true;
            }
        }

        return encontrado;
    }
    boolean existeProfesor(Profesor profesor) {
        lisProfesores = mostrarProfesores();
        if (lisProfesores == null) return false;

        boolean encontrado = false;

        for (Profesor profesor1 : lisProfesores){
            if (profesor1.getID() == profesor.getID()){
                encontrado = true;
            }
        }

        return encontrado;

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