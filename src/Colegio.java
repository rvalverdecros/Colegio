import java.util.ArrayList;

public class Colegio {

    private String nombre;

    private ArrayList<Aula> aulas = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private ArrayList<Profesor> profesores = new ArrayList<>();
    private Direccion direccion = new Direccion(3);

    void anadirAula(Aula aula){
        aulas.add(aula);
    }



    public Colegio(String nombre) {
        this.nombre = nombre;
    }
}
