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
    private TestConex testConex = new TestConex();

    // Constructor
    public Colegio(String nombre) {
        this.nombre = nombre;
    }

    // Métodos
    void anadirAula (Aula aula) { 
    	
    	
    	aulas.add(aula); 
    	
    	
    	testConex.insertAula(aula.getNombreAula(), aula.isPizarra(), aula.getSillas(), aula.getMesas(),aula.getEstado());
    	
    }
    void anadirCurso (Curso curso) { 
    	cursos.add(curso); 
    	
    	
    	
    	testConex.insertCurso(curso.getNombre());
    	
    	}
    void anadirAlumno (Alumno alumno) { 
    	alumnos.add(alumno);
    	
    	testConex.insertAlumno(alumno.getNombre(),alumno.getDni(),alumno.getEdad(),alumno.getSexo(),alumno.getEstadoAlumno());
    }
    void anadirProfesor (Profesor profesor) { 
    	profesores.add(profesor);
    	
    	testConex.insertProfesor(profesor.getNombre(),profesor.getDni(),profesor.getEdad(),profesor.getSexo(),profesor.getEstadoProfesor());
    	}

    String mostrarAula () {
        StringBuilder aulasAMostrar = new StringBuilder();
        for (Aula aula : getAulas()) {
            aulasAMostrar.append(aula);
            aulasAMostrar.append("\n");
        }
        return aulasAMostrar.toString();
    }

    ArrayList<Aula> getAulas(){
        return testConex.selectAulas();
    }

    Aula findAula(int idAula){
        Aula aulaSearch = null;

        for (Aula aula : getAulas()){
            if (aula.getId() == idAula){
                aulaSearch = aula;
            }
        }

        return aulaSearch;
    }

    String mostrarCurso () {
        StringBuilder cursosAMostrar = new StringBuilder();
        for (Curso curso : getCursos()) {
            cursosAMostrar.append(curso.toString());
            cursosAMostrar.append("\n");
        }
        return cursosAMostrar.toString();
    }

    ArrayList<Curso> getCursos(){ return testConex.selectCursos(); }

    Curso findCurso(int idCurso){
        Curso cursoSearch = null;

        for (Curso curso : getCursos()){
            if (curso.getID() == idCurso){
                cursoSearch = curso;
            }
        }
        return cursoSearch;
    }
    String mostrarAlumno () {
        StringBuilder alumnosAMostrar = new StringBuilder();
        for (Alumno alumno : getAlumnos()) {
            alumnosAMostrar.append(alumno);
            alumnosAMostrar.append("\n");
        }
        return alumnosAMostrar.toString();
    }

    ArrayList<Alumno> getAlumnos(){ return testConex.selectAlumnos(); }

    Alumno findAlumno(int idAlumno){
        Alumno alumnoSearch = null;

        for (Alumno alumno : getAlumnos()){
            if (alumno.getID() == idAlumno){
                alumnoSearch = alumno;
            }
        }
        return alumnoSearch;
    }

    String mostrarProfesor () {
        StringBuilder profesoresAMostrar = new StringBuilder();
        for (Profesor profesor : getProfesores()) {
            profesoresAMostrar.append(profesor);
            profesoresAMostrar.append("\n");
        }
        return profesoresAMostrar.toString();
    }

    ArrayList<Profesor> getProfesores(){
        return testConex.selectProfesores();
    }

    Profesor findProfesor(int idProfesor){
        Profesor profesorSearch = null;

        for (Profesor profesor : getProfesores()){
            if (profesor.getID() == idProfesor){
               profesorSearch = profesor;
            }
        }
        return profesorSearch;
    }

    void eliminarAula(int numero) { 
    	
    	//aulas.remove(numero);
    	testConex.deleteAula(numero);
    	
    	}
    void eliminarCurso(int numero) { 
    	
    	//cursos.remove(numero);
    	testConex.deleteCurso(numero);
    	
    	}
    void eliminarAlumnos(int numero) { 
    	
    	//alumnos.remove(numero);
    	testConex.deleteAlumno(numero);
    	
    	}
    void eliminarProfesores(int numero){
    	
        //profesores.remove(numero);
        testConex.deleteProfesor(numero);
        
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
