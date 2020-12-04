package trabengIII.Entity;

public class RecipienteProduto {
    private int rec_id;
    private String rec_descricao;

    public RecipienteProduto() {
    }

    public RecipienteProduto(int rec_id, String rec_descricao) {
        this.rec_id = rec_id;
        this.rec_descricao = rec_descricao;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_descricao() {
        return rec_descricao;
    }

    public void setRec_descricao(String rec_descricao) {
        this.rec_descricao = rec_descricao;
    }

    @Override
    public String toString() {
        return rec_descricao;
    }
}
