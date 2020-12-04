package trabengIII.Entity;


public class ItensVenda {
   
    private Produto prod;
    private int qtd;
    private Operacao vend;
       
    public ItensVenda(Produto prod, int qtd, Operacao vend){
        
        this.prod = prod;
        this.qtd = qtd;
        this.vend = vend;
    }

    public ItensVenda(Produto prod, int qtd) {
        this.prod = prod;
        this.qtd = qtd;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Operacao getVend() {
        return vend;
    }

    public void setVend(Operacao vend) {
        this.vend = vend;
    }
}
