public abstract class Persona {

    protected String dni;
    protected String nombre;
    protected int edad;
    protected char sexo;

    public String getDni() { return this.dni;}
    public String getNombre() { return this.nombre;}
    public int getEdad() { return this.edad;}
    public char getSexo() { return sexo; }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
