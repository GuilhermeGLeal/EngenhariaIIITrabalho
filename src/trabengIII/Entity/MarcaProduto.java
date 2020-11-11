package trabengIII.Entity;

public class MarcaProduto {
    private int mar_id;
    private String mar_descricao;

    public MarcaProduto() {
    }

    public MarcaProduto(int mar_id, String mar_descricao) {
        this.mar_id = mar_id;
        this.mar_descricao = mar_descricao;
    }

    public int getMar_id() {
        return mar_id;
    }

    public void setMar_id(int mar_id) {
        this.mar_id = mar_id;
    }

    public String getMar_descricao() {
        return mar_descricao;
    }

    public void setMar_descricao(String mar_descricao) {
        this.mar_descricao = mar_descricao;
    }

    @Override
    public String toString() {
        return "MarcaProduto{" + "mar_descricao=" + mar_descricao + '}';
    }
}
