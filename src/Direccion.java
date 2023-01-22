public class Direccion implements JuntaDirectiva {
    // Atributos
    private int npersonas;
    private boolean decision;
    private boolean juntadecision;

    // Constructor
    public Direccion(int personas){
        this.npersonas = personas;
        decision = true;
    }

    // Getter y Setter
    public int getNpersonas(){
        return npersonas;
    }
    public void setNpersonas(int npersonas){
        this.npersonas = npersonas;
    }

    // Métodos públicos
    @Override
    public void afirmacion() { juntadecision = true; }
    @Override
    public void negacion() { juntadecision = false; }
    public void denegarDecision() { decision = false; }
    public void aceptarDecision() { decision = true; }

}
