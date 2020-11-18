package trabengIII.Entity;

import java.time.LocalDate;

public class Varejo extends Venda{

    public Varejo() {
    }

    public Varejo(int ven_id, Cliente ven_cli, double ven_total, LocalDate ven_data, char ven_tipo) {
        super(ven_id, ven_cli, ven_total, ven_data, ven_tipo);
    }
}
