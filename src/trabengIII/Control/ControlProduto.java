package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALProduto;
import trabengIII.Entity.Produto;


public class ControlProduto {

    private Produto produto;
    private List<Produto> produtoTodos;

    public ControlProduto() {
        
        this.produto = new Produto();
        this.produtoTodos = new ArrayList();
    }
    
    
    public void listarProdutos(){
        
        DALProduto dal = new DALProduto();
        this.produtoTodos = dal.get("");
    }    

    public Produto getProduto() {
        return produto;
    }

    public List<Produto> getProdutoTodos() {
        return produtoTodos;
    }
    
    
}

