import java.util.ArrayList;

public class Profesor extends Persona {
    private String estado;

    private ArrayList<Material> lisMateriales;

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
