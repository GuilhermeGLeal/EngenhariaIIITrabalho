package trabengIII.Control;

import java.time.LocalDate;
import java.util.List;
import trabengIII.DAL.DALVenda;
import trabengIII.Entity.Atacado;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.ItensVenda;
import trabengIII.Entity.Operacao;
import trabengIII.Entity.Varejo;

public class ControlOperacao {
    
    private Operacao op;

    public ControlOperacao() {
        
    }
    
    
    public boolean gravar(Cliente cli, double venda, LocalDate vendata, char tipo, List<ItensVenda> itens){
        
        boolean resultado = false;
        
        if(tipo == 'A'){
            
            op = new Atacado(0, cli, venda, vendata, tipo);
            op.setItens(itens);
            op.aplicarDesconto();
        }
        else{
            op = new Varejo(0, cli, venda, vendata, tipo);
            op.setItens(itens);
           
        }
        
        DALVenda dal = new DALVenda();
        resultado = dal.gravar(op);
        return resultado;
    }
    
    
}
