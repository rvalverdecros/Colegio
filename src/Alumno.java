import java.util.ArrayList;

public class Alumno extends Persona {
    // Atributos
    String estado;
    private ArrayList<Material> lisMateriales;

    // Constructor primario y secundario
    Alumno(String dni, String nombre, int edad, String sexo, String estado){
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoAlumno(sexo);
        estadoAlumno(estado);
    }

    Alumno(String dni, String nombre, int edad, String sexo){
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoAlumno(sexo);
        setEstado("Nuevo");
    }

    // Getter y Setter de estado
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Métodos privados
    private void estadoAlumno(String estado) {
        if (estado != "Nuevo".toLowerCase()||estado != "Repetidor".toLowerCase()) estado = "Nuevo";
        this.estado = estado;
    }

    private void sexoAlumno(String sexo){
        if (sexo.toLowerCase() != "hombre" || sexo.toLowerCase() != "mujer") {
            setSexo("hombre");
        }else {
            setSexo(sexo);
        }
    }

    private void edadNoNegativa(int edad) {
        if (edad < 0) throw new IllegalArgumentException("[ERROR]: Ha introducido una edad negativa");
        setEdad(edad);
    }

    // Métodos
    void anadirMaterial(Material material) { lisMateriales.add(material); }
    void dejarMaterial(Material material) { lisMateriales.remove(material); }
    boolean existeMaterial(Material material) { return lisMateriales.contains(material); }

    public String toString() {
        return "ALUMNO\n" +
                "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo :" + sexo + "\n"
                + "DNI: " + dni + "\n"
                + "Estado: " + estado;
    }
}