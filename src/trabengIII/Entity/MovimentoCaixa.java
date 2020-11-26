package trabengIII.Entity;

import trabengIII.Interface.ReceberPagar;

public class MovimentoCaixa {
    private PagamentoRecebimento movimento_conta;
    private Caixa movimento_caixa;

    public PagamentoRecebimento getMovimento_conta() {
        return movimento_conta;
    }

    public void setMovimento_conta(PagamentoRecebimento movimento_conta) {
        this.movimento_conta = movimento_conta;
    }

    public Caixa getMovimento_caixa() {
        return movimento_caixa;
    }

    public void setMovimento_caixa(Caixa movimento_caixa) {
        this.movimento_caixa = movimento_caixa;
    }

    public MovimentoCaixa(PagamentoRecebimento movimento_conta, Caixa movimento_caixa) {
        this.movimento_conta = movimento_conta;
        this.movimento_caixa = movimento_caixa;
    }

    public MovimentoCaixa() {
    }

    
    
}
