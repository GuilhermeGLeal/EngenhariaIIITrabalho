package trabengIII.Entity;

import trabengIII.Interface.ReceberPagar;

public class Boleto implements ReceberPagar{
   
    @Override
    public double efetuarOperacao(double valoratual) {
        
        return valoratual - (valoratual * 0.15);
    }
}
