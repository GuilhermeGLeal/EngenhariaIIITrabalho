package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALTipo;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.TipoProduto;
import trabengIII.Interface.Observador;


public class ControlTipoProduto {
    
    private TipoProduto tipo;
    private List<TipoProduto> tipoTodos;

    public ControlTipoProduto() {
        
        this.tipo = new TipoProduto();
        this.tipoTodos = new ArrayList();
    }
    
    
    public void adicionarFavorito(int indexTipo, Cliente cli){
        
        this.tipoTodos.get(indexTipo).adicionar(cli);
        gravarFavorito(indexTipo);
    }
    
     public void removerFavorito(int indexTipo, Cliente cli){
        
        this.tipoTodos.get(indexTipo).remover(cli);
        gravarFavorito(indexTipo);
    }
     
    public List<Observador> retornaFavoritoTipo(int indexTipo){
        
        List<Observador> todos = this.tipoTodos.get(indexTipo).getLo();
        
        return todos;
    }
    
    public boolean gravarFavorito(int index){
        
        boolean res = false;
        DALTipo dal = new DALTipo();
        TipoProduto tip =  tipoTodos.get(index);
        
        res = dal.atualizar(tip);
        
        return res;
    }
    
    public void listarTipos(){
        
        DALTipo dal = new DALTipo();
        this.tipoTodos = dal.get("");
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public List<TipoProduto> getTipoTodos() {
        return tipoTodos;
    }

   
}
