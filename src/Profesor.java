import java.util.ArrayList;

public class Profesor extends Persona {
    // Atributos
	private int id;
    private String estado;
    private boolean miembroDirectivo;
    private ArrayList<Material> lisMateriales;
    private Curso curso;
    private TestConex testConex = new TestConex();

    // Constructores
    Profesor(String dni, String nombre, int edad, String sexo, String estado) {
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoProfesor(sexo);
        estadoCorrecto(estado);
    }
    
    Profesor(int id, String dni, String nombre, int edad, String sexo, String estado, Curso curso){
    	setID(id);
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoProfesor(sexo);
        estadoCorrecto(estado);
        setCurso(curso);
    }

    Profesor(String dni, String nombre, int edad, String sexo) {
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoProfesor(sexo);
        setEstadoProfesor("Nuevo");
    }

    // Getters y Setters
    public String getEstadoProfesor() { return estado; }
    public void setEstadoProfesor(String estado) { 
    	estadoCorrecto(estado);
    	}
    
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { 
    	this.curso = curso;
    	}

    public boolean isMiembroDirectivo() { return miembroDirectivo; }
    public void setMiembroDirectivo(boolean miembroDirectivo) { this.miembroDirectivo = miembroDirectivo; }

    public String getSexoProfesor() { return sexo; }
    public void setSexoProfesor(String sexo) { 
    	sexoProfesor(sexo); }
    
    public int getEdadProfesor() { return getEdad(); }
    public void setEdadProfesor(int edad) { 
    	edadNoNegativa(edad);
    	
    	}
    public String getNombreProfesor() { return getNombre(); }
    public void setNombreProfesor(String nombre) { 
    	setNombre(nombre);
    	testConex.setNombreProfesor(id,nombre);
    	}
    
    public String getDNIProfesor() { return getDni(); }
    public void setDNIProfesor(String dni) { 
    	setDni(dni);
    	testConex.setDNIProfesor(id,dni);
    	}

    // Métodos privados
    private void sexoProfesor(String sexo) {
        if (sexo.toLowerCase() != "hombre" || sexo.toLowerCase() != "mujer") {
            this.sexo = "hombre";
            testConex.setSexoProfesor(id,"hombre");
        }else {
            this.sexo = sexo;
            testConex.setSexoProfesor(id,sexo);
        }
    }

    private void edadNoNegativa(int edad) {
        if (edad < 0) throw new IllegalArgumentException("[ERROR]: Ha introducido una edad negativa");
        setEdad(edad);
        testConex.setEdadProfesor(id,edad);
    }

    private void estadoCorrecto(String estado) {
        if (estado != "Nuevo".toLowerCase() || estado != "Jubilado".toLowerCase()) this.estado = "Nuevo";
        this.estado = estado;
        testConex.setEstadoProfesor(id,estado);
    }

    // Métodos
    void anadirMaterialProfesor(Material material){
        //lisMateriales.add(material);
        testConex.añadirMaterialProfesor(id,material.getNombre());
    }
    void dejarMaterialProfesor(Material material){ 
    	//lisMateriales.remove(material);
    	testConex.borrarMaterialProfesor(id,material.getNombre());
    	}
    boolean existeMaterialProfesor(Material material) { 
    	return testConex.existeMaterialProfesor(id,material.getNombre());
    	}

    public String toString() {
        String directivo = "";
        if (miembroDirectivo) directivo = "Sí"; else directivo = "No";

        return "PROFESOR\n" +
        "ID:" + id + "\n"
		+"Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo :" + sexo + "\n"
                + "DNI: " + dni + "\n"
                + "Miembro directivo: " + directivo + "\n"
                + "Estado: " + estado;
    }
}
