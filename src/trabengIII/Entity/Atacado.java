package trabengIII.Entity;

import java.time.LocalDate;

public class Atacado extends Operacao{
   

    public Atacado() {
    }

    public Atacado(int ven_id, Cliente ven_cli, double ven_total, LocalDate ven_data, char ven_tipo) {
        super(ven_id, ven_cli, ven_total, ven_data, ven_tipo);
       
    }

    @Override
    public void aplicarDesconto(){
        
        this.setVen_total(this.getVen_total() - (this.getVen_total() * 0.10));
    }
}
