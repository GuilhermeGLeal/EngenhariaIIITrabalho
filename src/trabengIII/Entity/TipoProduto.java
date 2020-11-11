package trabengIII.Entity;

public class TipoProduto {
    private int tip_id;
    private String tip_descricao;

    public TipoProduto() {
    }

    public TipoProduto(int tip_id, String tip_descricao) {
        this.tip_id = tip_id;
        this.tip_descricao = tip_descricao;
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

    @Override
    public String toString() {
        return "TipoProduto{" + "tip_descricao=" + tip_descricao + '}';
    }
}
