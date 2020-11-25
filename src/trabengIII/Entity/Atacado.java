package trabengIII.Entity;

import java.time.LocalDate;

public class Atacado extends Operacao{
    private double desconto;

    public Atacado() {
    }

    public Atacado(int ven_id, Cliente ven_cli, double ven_total, LocalDate ven_data, char ven_tipo) {
        super(ven_id, ven_cli, ven_total, ven_data, ven_tipo);
    }

    public Atacado(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
