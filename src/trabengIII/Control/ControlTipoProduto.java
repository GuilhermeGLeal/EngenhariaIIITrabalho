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
    
    
    public boolean verificaFavoritoExistente(TipoProduto tip, Cliente cli){
     
        boolean res = true;
        
        for (int i = 0; i < tip.getLo().size() && res; i++) {
              
            Cliente cli2 = (Cliente) tip.getLo().get(i);
            
            if(cli2.getCli_id() == cli.getCli_id())
                res = false;
            
        }
        
        return res;
    }
    
    public boolean adicionarFavorito(TipoProduto tipo, Cliente cli){
        
        boolean res = verificaFavoritoExistente(tipo, cli);
        
        if(res){
            
             tipo.adicionar(cli);
             gravarFavorito(tipo);
        }
       
        return res;
    }
    
     public void removerFavorito(TipoProduto tip, Cliente cli){
        
        tip.remover(cli);
        gravarFavorito(tip);
    }
    
    public String notificaTodos(TipoProduto tip, double desconto){
        
        int cont;
        tip.setDesconto(desconto);
        cont = tip.notificar();
        String mensagem = "";
        
        if(cont == 0){
            
            mensagem = "Nenhum cliente favoritou o tipo: "+tip.getTip_descricao();
        }
        else{
            
            mensagem = cont+" clientes foram notificados do desconto de "+desconto+"%";
        }
        
        return mensagem;
    }
    
    public List<Favorito> retornarList(TipoProduto tip){
        
        List<Favorito> favs = new ArrayList();
        List<Observador> todos = tip.getLo();
          
        for (int i = 0; i < todos.size(); i++) {
            
            Cliente cli = (Cliente) todos.get(i);
            favs.add(new Favorito(tip, cli));
        }
        
        return favs;
        
    }
    
    public ObservableList<Favorito> retornarListFav(TipoProduto tip){
        
      
        List<Favorito> favs = retornarList(tip);
        ObservableList<Favorito> modeloFavs =  FXCollections.observableArrayList(favs);
        return modeloFavs;
    }
    
    public boolean gravarFavorito(TipoProduto tip){
        
        boolean res = false;
        DALTipo dal = new DALTipo();
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
        listarTipos();
        return tipoTodos;
    }

   
}
