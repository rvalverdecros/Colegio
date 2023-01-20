public class Aula {
    private String nombreAula;
    private boolean pizarra;
    private int sillas;
    private int mesas;
    private EstadoAula estado;
    private Curso curso;

    // Constructor primario con todos los atributos como parámetros
    public Aula(String nombreAula, boolean pizarra, int sillas, int mesas) {
        this.nombreAula = nombreAula;
        this.pizarra = pizarra;
        sillasNotZeroOrLess(sillas);
        mesasNotZeroOrLess(mesas);
    }

    // Constructor secundario en el que no se incluye pizarra, y ésta se setea a false
    public Aula(String nombreAula, int sillas, int mesas) {
        this.nombreAula = nombreAula;
        sillasNotZeroOrLess(sillas);
        mesasNotZeroOrLess(mesas);
        pizarra = false;
    }

    // Getters y Setters



    public String getNombreAula() { return nombreAula; }
    public void setNombreAula(String nombreAula) { this.nombreAula = nombreAula; }

    public boolean isPizarra() { return pizarra; }
    public void setPizarra(boolean pizarra) { this.pizarra = pizarra; }

    public int getSillas() { return sillas; }
    public void setSillas(int sillas) { this.sillas = sillas; }

    public int getMesas() { return mesas; }
    public void setMesas(int mesas) { this.mesas = mesas; }

    public EstadoAula getEstado() { return estado; }

    // Métodos privados
    private void sillasNotZeroOrLess(int sillas) {
        if (sillas < 0) sillas = 0;
        this.sillas = sillas;
    }
    private void mesasNotZeroOrLess(int mesas) {
        if (mesas < 0) mesas = 0;
        this.mesas = mesas;
    }

    public String toString() {
        String tienePizarra = "";
        if (pizarra) tienePizarra = "Sí"; else tienePizarra = "No";

        return "AULA: " + nombreAula + "\n"
                + "Pizarra: " + tienePizarra + "\n"
                + "Sillas: " + sillas + "\n"
                + "Mesas: " + mesas + "\n"
                + "Estado: " + estado;
    }

}
