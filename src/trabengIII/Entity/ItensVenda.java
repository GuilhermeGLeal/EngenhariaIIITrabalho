package trabengIII.Entity;


public class ItensVenda {
   
    private Produto prod;
    private int qtd;
    private Operacao vend;
    private static ItensVenda iten = null;
       
    private ItensVenda(Produto prod, int qtd, Operacao vend){
        
        this.prod = prod;
        this.qtd = qtd;
        this.vend = vend;
    }
    
    public static ItensVenda criarItem(Produto prod, int qtd, Operacao vend){
     
        
        
        
        
        return null;
    }
}
