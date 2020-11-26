package trabengIII.Entity;

import trabengIII.Interface.ReceberPagar;

public class Cartao implements ReceberPagar{
    
    @Override
    public double efetuarOperacao(double valoratual) {
        
        return valoratual + (valoratual * 0.015);
    }
}
