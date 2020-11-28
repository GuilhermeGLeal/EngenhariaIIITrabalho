package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALMarca;
import trabengIII.Entity.MarcaProduto;


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
        return marcaTodos;
    }

  
    
    
}
