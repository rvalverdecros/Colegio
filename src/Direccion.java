public class Direccion implements JuntaDirectiva {
    private int npersonas;
    private boolean decision;
    private boolean juntadecision;

    public Direccion(int personas){
        this.npersonas = personas;
        decision = true;
    }

    @Override
    public void afirmacion(){
        juntadecision = true;
    }

    @Override
    public void negacion(){
        juntadecision = false;
    }

    public void denegarDecision(){
        decision = false;
    }

    public void aceptarDecision(){
        decision = true;
    }
    public int getNpersonas(){
        return npersonas;
    }

    public void setNpersonas(int npersonas){
        this.npersonas = npersonas;
    }
}
