public class Profesor extends Persona {
    String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    Profesor(String dni, String nombre, int edad, char sexo, String estado){
        setDni(dni);
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        setEstado(estado);
    }

    Profesor(String dni, String nombre, int edad, char sexo){
        setDni(dni);
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        setEstado("Nuevo");
    }


}
