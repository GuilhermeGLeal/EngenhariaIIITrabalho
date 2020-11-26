package trabengIII.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Caixa {
    private int id;
    private LocalDate abertura;
    private LocalDate fechamento;
    private double inicial;
    private double vfinal;

    public Caixa() {
    }

    public Caixa(int id, LocalDate abertura, LocalDate fechamento, double inicial, double vfinal) {
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

    public LocalDate getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura;
    }

    public LocalDate getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDate fechamento) {
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
