package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALMarca;
import trabengIII.DAL.DALProduto;
import trabengIII.Entity.MarcaProduto;
import trabengIII.Entity.Produto;
import trabengIII.Entity.RecipienteProduto;
import trabengIII.Entity.TipoProduto;
import trabengIII.Entity.UnidadeMedida;


public class ControlMarcaProduto {
    
    private MarcaProduto marca;
    private List<MarcaProduto> marcaTodos;

    public ControlMarcaProduto() {
        
        this.marca = new MarcaProduto();
        this.marcaTodos = new ArrayList();
    }
    
    public void listarMarcas(){
        
        DALMarca dal = new DALMarca();
        this.marcaTodos = dal.get("");
    }

    public MarcaProduto getMarca() {
        return marca;
    }

    public List<MarcaProduto> getMarcaTodos() {
        listarMarcas();
        return marcaTodos;
    }

    public List<Produto> dalP(MarcaProduto mar, RecipienteProduto rec, TipoProduto tip, UnidadeMedida uni) {
        return new DALProduto().get("pro_marca="+mar.getMar_id()+" and pro_recipiente="+rec.getRec_id()+" and pro_tipo="+tip.getTip_id()+" and pro_medida="+uni.getUni_id());
    }
}
