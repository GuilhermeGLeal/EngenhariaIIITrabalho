package trabengIII.Entity;

public class MovimentoCaixa {
    private int movimento_conta;
    private int movimento_caixa;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int movimento_conta, int movimento_caixa) {
        this.movimento_conta = movimento_conta;
        this.movimento_caixa = movimento_caixa;
    }

    public int getMovimento_conta() {
        return movimento_conta;
    }

    public void setMovimento_conta(int movimento_conta) {
        this.movimento_conta = movimento_conta;
    }

    public int getMovimento_caixa() {
        return movimento_caixa;
    }

    public void setMovimento_caixa(int movimento_caixa) {
        this.movimento_caixa = movimento_caixa;
    }
}
