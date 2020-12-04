package trabengIII.Control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALVenda;
import trabengIII.Entity.Atacado;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.ItensVenda;
import trabengIII.Entity.Operacao;
import trabengIII.Entity.Produto;
import trabengIII.Entity.Varejo;

public class ControlOperacao {
    
    private Operacao op;
    private List<ItensVenda> itensV;

    public ControlOperacao() {
        itensV = new ArrayList();
    }
    
    public List<ItensVenda> retornarItensVenda(){
        
        return itensV;
    }
    
    public void adicionarItemVenda(int qtd, Produto prod){
        
        ItensVenda novo = new ItensVenda(prod, qtd, this.op);
        this.itensV.add(novo);
    }
        
    public boolean gravar(Cliente cli, double venda, LocalDate vendata, char tipo){
        
        boolean resultado = false;
        
        if(tipo == 'A'){
            
            op = new Atacado(0, cli, venda, vendata, tipo);
           op.aplicarDesconto();
        }
        else{
            op = new Varejo(0, cli, venda, vendata, tipo); 
           
        }
        
        DALVenda dal = new DALVenda();
        resultado = dal.gravar(op);
        return resultado;
    }
    
    
}
