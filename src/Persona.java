public abstract class Persona {
    // Atributos
    protected String dni;
    protected String nombre;
    protected int edad;
    protected String sexo;

    // Getters y Setters
    public String getDni() { return this.dni;}
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return this.nombre;}
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return this.edad;}
    public void setEdad(int edad) { this.edad = edad; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}