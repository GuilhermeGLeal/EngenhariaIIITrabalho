package trabengIII.Entity;

import java.util.ArrayList;
import java.util.List;
import trabengIII.Interface.Observador;
import trabengIII.Interface.Sujeito;

public class TipoProduto implements Sujeito {
    
    private int tip_id;
    private String tip_descricao;
    private List<Observador> lo;  
    private double desconto;
    
    public TipoProduto() {
    }

    public TipoProduto(int tip_id, String tip_descricao) {
        this.tip_id = tip_id;
        this.tip_descricao = tip_descricao;
        this.lo = new ArrayList();
        this.desconto = 0;
    }

    
    public int getTip_id() {
        return tip_id;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_descricao() {
        return tip_descricao;
    }

    public void setTip_descricao(String tip_descricao) {
        this.tip_descricao = tip_descricao;
    }

    public List<Observador> getLo() {
        return lo;
    }

    public void setLo(List<Observador> lo) {
        this.lo = lo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
        
        if(desconto > 0)
            this.notificar();
    }
    
    @Override
    public String toString() {
        return "TipoProduto{" + "tip_descricao=" + tip_descricao + '}';
    }

    @Override
    public void adicionar(Observador ob) {
        
        this.lo.add(ob);
    }

    @Override
    public void remover(Observador ob) {
       
        this.lo.remove(ob);
    }

    @Override
    public void notificar() {
      
        for (int i = 0; i < lo.size(); i++) {
            lo.get(i).atualizar(this, this.desconto);
        }
    }
}
