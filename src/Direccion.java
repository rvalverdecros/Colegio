public class Direccion {
    private int npersonas;
    private boolean decision;

    public Direccion(int personas){
        this.npersonas = personas;
        decision = true;
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
