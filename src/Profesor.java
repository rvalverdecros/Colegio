import java.util.ArrayList;

public class Profesor extends Persona {
    // Atributos
    private String estado;
    private boolean miembroDirectivo;
    private ArrayList<Material> lisMateriales;

    // Constructores
    Profesor(String dni, String nombre, int edad, char sexo, String estado) {
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoProfesor(sexo);
        estadoCorrecto(estado);
    }

    Profesor(String dni, String nombre, int edad, char sexo) {
        setDni(dni);
        setNombre(nombre);
        edadNoNegativa(edad);
        sexoProfesor(sexo);
        setEstado("Nuevo");
    }

    void anadirMaterial(Material material){
        lisMateriales.add(material);
    }

    void dejarMaterial(Material material){
        lisMateriales.remove(material);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado){
        estadoCorrecto(estado);
    }

    public boolean isMiembroDirectivo() {
        return miembroDirectivo;
    }

    public void setMiembroDirectivo(boolean miembroDirectivo) {
        this.miembroDirectivo = miembroDirectivo;
    }

    // Métodos privados
    private void sexoProfesor(char sexo) {
        if (sexo != 'H' || sexo != 'M') setSexo('H');
        setSexo(sexo);
    }

    private void edadNoNegativa(int edad) {
        if (edad < 0) throw new IllegalArgumentException("[ERROR]: Ha introducido una edad negativa");
        setEdad(edad);
    }

    private void estadoCorrecto(String estado) {
        if (estado != "Nuevo".toLowerCase() || estado != "Jubilado".toLowerCase()) this.estado = "Nuevo";
        this.estado = estado;
    }

    // Métodos
    public String toString() {
        String directivo = "";
        if (miembroDirectivo) directivo = "Sí"; else directivo = "No";

        return "PROFESOR\n" +
                "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo :" + sexo + "\n"
                + "DNI: " + dni + "\n"
                + "Miembro directivo: " + directivo + "\n"
                + "Estado: " + estado;
    }
}