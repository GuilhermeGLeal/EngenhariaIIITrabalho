package trabengIII.Entity;

import trabengIII.Interface.ReceberPagar;

public class Dinheiro implements ReceberPagar{
    
    @Override
    public double efetuarOperacao(double valoratual) {
 
        return valoratual - (valoratual * 0.05);
    }
}
