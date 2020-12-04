package trabengIII.Entity;

public class UnidadeMedida {
    private int uni_id;
    private String uni_descricao;

    public UnidadeMedida() {
    }

    public UnidadeMedida(int uni_id, String uni_descricao) {
        this.uni_id = uni_id;
        this.uni_descricao = uni_descricao;
    }

    public int getUni_id() {
        return uni_id;
    }

    public void setUni_id(int uni_id) {
        this.uni_id = uni_id;
    }

    public String getUni_descricao() {
        return uni_descricao;
    }

    public void setUni_descricao(String uni_descricao) {
        this.uni_descricao = uni_descricao;
    }

    @Override
    public String toString() {
        return uni_descricao;
    }
}
