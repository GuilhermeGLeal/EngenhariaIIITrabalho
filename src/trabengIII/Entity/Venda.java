package trabengIII.Entity;

import java.time.LocalDate;

public abstract class Venda {
    private int ven_id;
    private Cliente ven_cli;
    private double ven_total;
    private LocalDate ven_data;
    private char ven_tipo;

    public Venda() {
    }

    public Venda(int ven_id, Cliente ven_cli, double ven_total, LocalDate ven_data, char ven_tipo) {
        this.ven_id = ven_id;
        this.ven_cli = ven_cli;
        this.ven_total = ven_total;
        this.ven_data = ven_data;
        this.ven_tipo = ven_tipo;
    }

    public int getVen_id() {
        return ven_id;
    }

    public void setVen_id(int ven_id) {
        this.ven_id = ven_id;
    }

    public Cliente getVen_cli() {
        return ven_cli;
    }

    public void setVen_cli(Cliente ven_cli) {
        this.ven_cli = ven_cli;
    }

    public double getVen_total() {
        return ven_total;
    }

    public void setVen_total(double ven_total) {
        this.ven_total = ven_total;
    }

    public LocalDate getVen_data() {
        return ven_data;
    }

    public void setVen_data(LocalDate ven_data) {
        this.ven_data = ven_data;
    }

    public char getVen_tipo() {
        return ven_tipo;
    }

    public void setVen_tipo(char ven_tipo) {
        this.ven_tipo = ven_tipo;
    }
}
