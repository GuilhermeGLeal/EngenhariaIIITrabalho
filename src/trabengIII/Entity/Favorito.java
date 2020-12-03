package trabengIII.Entity;



public class Favorito {
   
    private TipoProduto tip;
    private Cliente cli;

    public Favorito(TipoProduto tip, Cliente cli) {
        this.tip = tip;
        this.cli = cli;
    }

    public Favorito() {
    }

    public TipoProduto getTip() {
        return tip;
    }

    public void setTip(TipoProduto tip) {
        this.tip = tip;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    
}
