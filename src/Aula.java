public class Aula {
    // Atributos
	private int id;
    private String nombreAula;
    private boolean pizarra;
    private int sillas;
    private int mesas;
    private String estado;
    private Curso curso;
    private TestConex testConex = new TestConex();

    // Constructor primario con todos los atributos como parámetros
    public Aula(String nombreAula, boolean pizarra, int sillas, int mesas) {
        this.nombreAula = nombreAula;
        this.pizarra = pizarra;
        sillasNotZeroOrLess(sillas);
        mesasNotZeroOrLess(mesas);
    }
    
    public Aula(int id,String nombreAula, boolean pizarra, int sillas, int mesas, String estado, Curso curso) {
    	this.id = id;
        this.nombreAula = nombreAula;
        this.pizarra = pizarra;
        sillasNotZeroOrLess(sillas);
        mesasNotZeroOrLess(mesas);
        this.estado = estado;
        this.curso = curso;
    }

    // Constructor secundario en el que no se incluye pizarra, y ésta se setea a false
    public Aula(String nombreAula, int sillas, int mesas) {
        this.nombreAula = nombreAula;
        sillasNotZeroOrLess(sillas);
        mesasNotZeroOrLess(mesas);
        pizarra = false;
    }

    public int getId() {
        return id;
    }

    // Getters y Setters
    public String getNombreAula() { return nombreAula; }
    public void setNombreAula(String nombreAula) { 
    	this.nombreAula = nombreAula;
    	testConex.setNombreAula(id,nombreAula);
    	}

    public boolean isPizarra() { return pizarra; }
    public void setPizarra(boolean pizarra) { 
    	this.pizarra = pizarra;
    	testConex.setPizarra(id,pizarra);
    	}

    public int getSillas() { return sillas; }
    public void setSillas(int sillas) { 
    	this.sillas = sillas;
    	testConex.setSillas(id,sillas);
    	}

    public int getMesas() { return mesas; }
    public void setMesas(int mesas) { 
    	this.mesas = mesas;
    	testConex.setMesas(id,mesas);
    	}

    public String getEstado() { return estado; }

    public void setEstado(String estado) {
        this.estado = estado;
        testConex.setEstado(id,estado);
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        testConex.setCurso(id,curso.getID());
    }

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

        String nombreCurso;

        if(curso != null){
            nombreCurso = curso.getNombre();
        }else{
            nombreCurso = "";
        }

        return 
        		"ID:" + id + "\n"
        		+"AULA: " + nombreAula + "\n"
                + "Pizarra: " + tienePizarra + "\n"
                + "Sillas: " + sillas + "\n"
                + "Mesas: " + mesas + "\n"
                + "Estado: " + estado + "\n"
                + "Curso:" + nombreCurso;
    }
}
