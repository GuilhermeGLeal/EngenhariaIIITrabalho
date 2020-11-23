package trabengIII.Entity;

import trabengIII.Interface.ReceberPagar;

public class MovimentoCaixa {
    private ReceberPagar movimento_conta;
    private Caixa movimento_caixa;

    public ReceberPagar getMovimento_conta() {
        return movimento_conta;
    }

    public void setMovimento_conta(ReceberPagar movimento_conta) {
        this.movimento_conta = movimento_conta;
    }

    public Caixa getMovimento_caixa() {
        return movimento_caixa;
    }

    public void setMovimento_caixa(Caixa movimento_caixa) {
        this.movimento_caixa = movimento_caixa;
    }

    public MovimentoCaixa(ReceberPagar movimento_conta, Caixa movimento_caixa) {
        this.movimento_conta = movimento_conta;
        this.movimento_caixa = movimento_caixa;
    }

    public MovimentoCaixa() {
    }

    
    
}
