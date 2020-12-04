package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import trabengIII.DAL.DALRecepiente;
import trabengIII.Entity.RecipienteProduto;


public class ControlRecipienteProduto {
    
    private RecipienteProduto recipiente;
    private List<RecipienteProduto> recipienteTodos;

    public ControlRecipienteProduto() {
        
        this.recipiente = new RecipienteProduto();
        this.recipienteTodos = new ArrayList();
    }
    
    
    public void listarUnidades(){
        
        DALRecepiente dal = new DALRecepiente();
        this.recipienteTodos = dal.get("");
    }

    public RecipienteProduto getRecipiente() {
        return recipiente;
    }

    public List<RecipienteProduto> getRecipienteTodos() {
        listarUnidades();
        return recipienteTodos;
    }
    
}
