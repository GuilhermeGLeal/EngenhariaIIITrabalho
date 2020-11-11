package trabengIII.Entity;

public class Produto {
    private int pro_id;
    private String pro_nome;
    private double pro_preco;
    private int pro_qtd;
    private TipoProduto tip_pro;
    private MarcaProduto mar_pro;
    private RecipienteProduto rec_pro;
    private UnidadeMedida uni_pro;

    public Produto() {
    }

    public Produto(int pro_id, String pro_nome, double pro_preco, int pro_qtd, TipoProduto tip_pro, MarcaProduto mar_pro, RecipienteProduto rec_pro, UnidadeMedida uni_pro) {
        this.pro_id = pro_id;
        this.pro_nome = pro_nome;
        this.pro_preco = pro_preco;
        this.pro_qtd = pro_qtd;
        this.tip_pro = tip_pro;
        this.mar_pro = mar_pro;
        this.rec_pro = rec_pro;
        this.uni_pro = uni_pro;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public double getPro_preco() {
        return pro_preco;
    }

    public void setPro_preco(double pro_preco) {
        this.pro_preco = pro_preco;
    }

    public int getPro_qtd() {
        return pro_qtd;
    }

    public void setPro_qtd(int pro_qtd) {
        this.pro_qtd = pro_qtd;
    }

    public TipoProduto getTip_pro() {
        return tip_pro;
    }

    public void setTip_pro(TipoProduto tip_pro) {
        this.tip_pro = tip_pro;
    }

    public MarcaProduto getMar_pro() {
        return mar_pro;
    }

    public void setMar_pro(MarcaProduto mar_pro) {
        this.mar_pro = mar_pro;
    }

    public RecipienteProduto getRec_pro() {
        return rec_pro;
    }

    public void setRec_pro(RecipienteProduto rec_pro) {
        this.rec_pro = rec_pro;
    }

    public UnidadeMedida getUni_pro() {
        return uni_pro;
    }

    public void setUni_pro(UnidadeMedida uni_pro) {
        this.uni_pro = uni_pro;
    }
}
