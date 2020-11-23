package trabengIII.Entity;


public class ItensVenda {
   
    private Produto prod;
    private int qtd;
    private Venda vend;
    private static ItensVenda iten = null;
       
    private ItensVenda(Produto prod, int qtd, Venda vend){
        
        this.prod = prod;
        this.qtd = qtd;
        this.vend = vend;
    }
    
    public static ItensVenda criarItem(Produto prod, int qtd, Venda vend){
     
        
        
        
        
        return null;
    }
}
