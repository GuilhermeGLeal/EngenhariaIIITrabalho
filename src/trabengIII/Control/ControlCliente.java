package trabengIII.Control;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import trabengIII.DAL.DALCliente;
import trabengIII.Entity.Cliente;


public class ControlCliente {
    
    private Cliente cliente;
    private List<Cliente> clienteTodos;

    public ControlCliente() {
        
        this.cliente = new Cliente();
        this.clienteTodos = new ArrayList();
    }
    
    
    public void listarCliente(){
        
        DALCliente dal = new DALCliente();
        this.clienteTodos = dal.get("");
    }

    public ObservableList<Cliente> retornarLista(){
        
       listarCliente();
       ObservableList<Cliente> modeloCli =  FXCollections.observableArrayList(clienteTodos);
     
        return modeloCli;
        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public List<Cliente> getClienteTodos() {
        listarCliente();
        return clienteTodos;
    }
    
    
}
