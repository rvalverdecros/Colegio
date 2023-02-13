import java.util.ArrayList;

public class Alumno extends Persona {
    // Atributos
	private int id;
    String estado;
    private ArrayList<Material> lisMateriales = new ArrayList<>();
    private Curso curso;
    private TestConex testConex = new TestConex();

    // Constructor primario y secundario
    Alumno(String dni, String nombre, int edad, String sexo, String estado){
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoAlumno(sexo);
        estadoAlumno(estado);
    }
    
    Alumno(int id, String dni, String nombre, int edad, String sexo, String estado, Curso curso){
    	setID(id);
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoAlumno(sexo);
        estadoAlumno(estado);
        setCurso(curso);
    }

    Alumno(String dni, String nombre, int edad, String sexo){
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoAlumno(sexo);
        setEstadoAlumno("Nuevo");
    }

    // Getter y Setter de estado
    public String getEstadoAlumno() { return estado; }
    public void setEstadoAlumno(String estado) { 
    	estadoAlumno(estado);
    	}
    
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { 
    	this.curso = curso;
    }

    public String getNombreAlumno() { return getNombre(); }
    public void setNombreAlumno(String nombre) { 
    	setNombre(nombre);
    	testConex.setNombreAlumno(id,nombre);
    	}
    
    public String getDNIAlumno() { return getDni(); }
    public void setDNIAlumno(String dni) { 
    	setDni(dni);
    	testConex.setDNIAlumno(id,dni);
    	}
    
    public int getEdadAlumno() { return getEdad(); }
    public void setEdadAlumno(int edad) { 
    	edadNoNegativa(edad);
    	
    	}
    
    public String getSexoAlumno() { return getSexo(); }
    public void setSexoAlumno(String sexo) { 
    	sexoAlumno(sexo);
    	}
    
    

    // Métodos privados
    private void estadoAlumno(String estado) {
        if (estado != "Nuevo".toLowerCase()||estado != "Repetidor".toLowerCase()) estado = "Nuevo";
        this.estado = estado;
        testConex.setNombreAlumno(id,estado);
    }

    private void sexoAlumno(String sexo){
        if (sexo.toLowerCase() != "hombre" || sexo.toLowerCase() != "mujer") {
            setSexo("hombre");
            testConex.setSexoAlumno(id,"hombre");
        }else {
            setSexo(sexo);
            testConex.setSexoAlumno(id,sexo);
        }
    }

    private void edadNoNegativa(int edad) {
        if (edad < 0) throw new IllegalArgumentException("[ERROR]: Ha introducido una edad negativa");
        setEdad(edad);
        testConex.setEdadAlumno(id,edad);
    }

    // Métodos
    void anadirMaterialAlumno(Material material) { 
    	lisMateriales.add(material);
    	testConex.añadirMaterialAlumno(id,material.getNombre());
    	}
    void dejarMaterialAlumno(Material material) { 
    	lisMateriales.remove(material);
    	testConex.borrarMaterialAlumno(id,material.getNombre());
    	}
    boolean existeMaterialAlumno(Material material) { 
    	return testConex.existeMaterialAlumno(id,material.getNombre());
    	}

    public String toString() {
        return "ALUMNO\n" +
        		"ID:" + id + "\n"
        		+"Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo :" + sexo + "\n"
                + "DNI: " + dni + "\n"
                + "Estado: " + estado;
    }
}