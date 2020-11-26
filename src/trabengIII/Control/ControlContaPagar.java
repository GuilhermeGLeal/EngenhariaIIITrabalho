package trabengIII.Control;

import trabengIII.DAL.DALCaixa;

public class ControlContaPagar extends ControlBaixarConta{

    @Override
    protected void atualizarCaixa() {
        
       double saldo = this.getCaixa().getVfinal();
       this.getCaixa().setVfinal(saldo - this.getReceberpagar().getVenda().getVen_total());
       
        DALCaixa dal = new DALCaixa();
        dal.alterar(this.getCaixa());
        
    }
    
}
