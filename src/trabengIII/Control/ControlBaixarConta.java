package trabengIII.Control;

import java.time.LocalDate;
import trabengIII.DAL.DALMovimentoCaixa;
import trabengIII.DAL.DALReceberPagar;
import trabengIII.DAL.DALCaixa;
import trabengIII.Entity.Caixa;
import trabengIII.Entity.MovimentoCaixa;
import trabengIII.Entity.Operacao;
import trabengIII.Entity.PagamentoRecebimento;

public abstract class ControlBaixarConta {
  
    private Caixa caixa;
    private MovimentoCaixa movcaixa;
    private PagamentoRecebimento receberpagar;

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public MovimentoCaixa getMovcaixa() {
        return movcaixa;
    }

    public void setMovcaixa(MovimentoCaixa movcaixa) {
        this.movcaixa = movcaixa;
    }

    public PagamentoRecebimento getReceberpagar() {
        return receberpagar;
    }

    public void setReceberpagar(PagamentoRecebimento receberpagar) {
        this.receberpagar = receberpagar;
    }

     public ControlBaixarConta() {
        
        this.caixa = null;
        this.movcaixa = null;
        this.receberpagar = null;
    }

    public final void gravar(Operacao op, char tipo, LocalDate emissoa, LocalDate dataPag, double valorPag, char tipopag) {
        if(caixa.isAberto()) {
            if(this.atualizarConta(op,  tipo,  emissoa,  dataPag,  valorPag,  tipopag)) {
                
                this.criarMovimento();
                this.atualizarCaixa();
            }
            else{
                // alert sem saldo
            }
        }
        else {
            // alert de caixa fechado
        }
    }
    
    protected void criarMovimento() {
        
        movcaixa = new MovimentoCaixa(receberpagar, caixa);
        DALMovimentoCaixa dal = new DALMovimentoCaixa();
        dal.gravar(movcaixa);
      
    }
    
    protected boolean atualizarConta(Operacao op, char tipo, LocalDate emissoa, LocalDate dataPag, double valorPag, char tipopag) {
        
        boolean result = false;
        
        if(tipopag == 'P' && caixa.getVfinal() >= op.getVen_total()){
            receberpagar = new PagamentoRecebimento(0, op, tipo, emissoa, dataPag, valorPag, tipopag);
            
        }
        else if(tipopag == 'R')           
            receberpagar = new PagamentoRecebimento(0, op, tipo, emissoa, dataPag, valorPag, tipopag);
        else
            return false;
             
        DALReceberPagar dal = new DALReceberPagar();
        result = dal.gravar(receberpagar);
        
        return result;
        
    }
    
    protected abstract void atualizarCaixa();
    
    protected void abrirCaixa(double inicial, LocalDate abertura){
        
        if(this.caixa == null){
            
             this.caixa = new  Caixa(0, abertura, null, inicial, inicial);
             DALCaixa dal = new DALCaixa();
             dal.gravar(this.caixa);
         }
        else{
         
            //mensamge
        }           
            
    }
     
     protected void fecharCaixa(){
        
        if(this.caixa != null){
            
            this.caixa.setFechamento(LocalDate.now());
             DALCaixa dal = new DALCaixa();
             dal.alterar(this.caixa);
         }
        else{
         
            //mensamge
        }           
            
    }
    
}
