package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabengIII.DAL.DALTipo;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.Favorito;
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
    
     public void removerFavorito(TipoProduto tip, Cliente cli){
        
        tip.remover(cli);
        gravarFavorito(tipoTodos.indexOf(tip));
    }
    
    public String notificaTodos(int index){
        
        int cont;
        TipoProduto tip = tipoTodos.get(index);
        cont = tip.notificar();
        
        if(cont == 0){
            
            // mensagem sem cliente favorito
        }
        else{
            
            // mensagem com qtd de clientes avisados
        }
        
        return "";
    }
    
    public List<Favorito> retornarList(int index){
        
        List<Favorito> favs = new ArrayList();
        List<Observador> todos = this.tipoTodos.get(index).getLo();
          
        for (int i = 0; i < todos.size(); i++) {
            
            favs.add(new Favorito(tipoTodos.get(index), (Cliente) todos.get(index)));
        }
        
        return favs;
        
    }
    
    public ObservableList<Favorito> retornarListFav(int indexTipo){
        
        ObservableList<Favorito> modeloFavs =  FXCollections.observableArrayList(retornarList(indexTipo));
        return modeloFavs;
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

    public ObservableList<TipoProduto> retornarTipos(){
        
       listarTipos();
       ObservableList<TipoProduto> modeloTipos =  FXCollections.observableArrayList(tipoTodos);
     
        return modeloTipos;
    }
        
    public TipoProduto getTipo() {
        return tipo;
    }

    public List<TipoProduto> getTipoTodos() {
        return tipoTodos;
    }

   
}
