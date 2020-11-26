package trabengIII.Control;

import trabengIII.Entity.Caixa;
import trabengIII.Entity.MovimentoCaixa;
import trabengIII.Entity.PagamentoRecebimento;
import trabengIII.Interface.ReceberPagar;

public abstract class ControlBaixarConta {
    private Caixa caixa;
    private MovimentoCaixa movcaixa;
    private PagamentoRecebimento receberpagar;

    public ControlBaixarConta() {
    }

    public ControlBaixarConta(Caixa caixa, MovimentoCaixa movcaixa, PagamentoRecebimento receberpagar) {
        this.caixa = caixa;
        this.movcaixa = movcaixa;
        this.receberpagar = receberpagar;
    }

    public final void gravar() {
        if(caixa.isAberto()) {
            if(this.atualizarConta()) {
                this.criarMovimento();
                this.atualizarCaixa();
            }
        }
        else {
            // alert de caixa fechado
        }
    }
    
    protected void criarMovimento() {
        movcaixa = new MovimentoCaixa(receberpagar, caixa);
        
        // salvar no banco chamando dal
    }
    
    protected boolean atualizarConta() {
        
        // verificar se é uma conta e tem saldo, criar conta e salvar no banco
        return false;
    }
    
    protected void atualizarCaixa() {
        // atualiza e salva no banco
    }
}
