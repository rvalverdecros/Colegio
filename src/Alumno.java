public class Alumno extends Persona {
    String estado;

    // Constructor primario y secundario
    Alumno(String dni, String nombre, int edad, char sexo, String estado){
        setDni(dni);
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        estadoAlumno(estado);
    }

    Alumno(String dni, String nombre, int edad, char sexo){
        setDni(dni);
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        setEstado("Nuevo");
    }

    // Getter y Setter de estado
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    // Métodos privados
    private void estadoAlumno(String estado) {
        if (estado != "Nuevo".toLowerCase() || estado != "Repetidor".toLowerCase()) estado = "Nuevo";
        this.estado = estado;
    }

    // Métodos
    public String toString() {
        return "ALUMNO\n" +
                "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Sexo :" + sexo + "\n"
                + "DNI: " + dni + "\n"
                + "Estado: " + estado;
    }
}
