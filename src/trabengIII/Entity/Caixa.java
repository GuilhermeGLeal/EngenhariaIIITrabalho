package trabengIII.Entity;

import java.util.Date;

public class Caixa {
    private int id;
    private Date abertura;
    private Date fechamento;
    private double inicial;
    private double vfinal;

    public Caixa() {
    }

    public Caixa(int id, Date abertura, Date fechamento, double inicial, double vfinal) {
        this.id = id;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.inicial = inicial;
        this.vfinal = vfinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public double getInicial() {
        return inicial;
    }

    public void setInicial(double inicial) {
        this.inicial = inicial;
    }

    public double getVfinal() {
        return vfinal;
    }

    public void setVfinal(double vfinal) {
        this.vfinal = vfinal;
    }
    
    public boolean isAberto () {
        return fechamento == null;
    }
}
