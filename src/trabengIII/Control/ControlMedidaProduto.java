package trabengIII.Control;
 
import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALMedida;
import trabengIII.Entity.UnidadeMedida;

public class ControlMedidaProduto {
    
    private UnidadeMedida unidade;
    private List<UnidadeMedida> unidadeTodos;

    public ControlMedidaProduto() {
        
        this.unidade = new UnidadeMedida();
        this.unidadeTodos = new ArrayList();
    }
    
    
    public void listarUnidades(){
        
        DALMedida dal = new DALMedida();
        this.unidadeTodos = dal.get("");
    }

    public UnidadeMedida getUnidade() {
        return unidade;
    }

    public List<UnidadeMedida> getUnidadeTodos() {
        return unidadeTodos;
    }

  
}
