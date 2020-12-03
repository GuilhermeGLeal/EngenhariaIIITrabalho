package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import trabengIII.DAL.DALCliente;
import trabengIII.DAL.DALMarca;
import trabengIII.DAL.DALMedida;
import trabengIII.DAL.DALRecepiente;
import trabengIII.DAL.DALTipo;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.MarcaProduto;
import trabengIII.Entity.RecipienteProduto;
import trabengIII.Entity.TipoProduto;
import trabengIII.Entity.UnidadeMedida;

public class FXMLDocumentController implements Initializable 
{    
    private Label label;
    @FXML
    private Button btMinizar;
    @FXML
    private Button btFechar;
    @FXML
    private JFXButton btFavoritar;
    @FXML
    private TableView<?> tvItensCompra;
    @FXML
    private JFXComboBox<MarcaProduto> cbMarca;
    @FXML
    private JFXComboBox<TipoProduto> cbTipo;
    @FXML
    private JFXComboBox<UnidadeMedida> cbMedida;
    @FXML
    private JFXComboBox<RecipienteProduto> cbRecipiente;
    @FXML
    private JFXComboBox<Cliente> cbCliente;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btRemover;
    @FXML
    private TableView<?> tvLeite;
    @FXML
    private JFXComboBox<String> cbTipoPagamento;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private JFXButton btComprar;
    private VBox vbPrincipal;
    @FXML
    private BorderPane bpPrincipal;
    
    private void inicializarCBs() {
        
        ArrayList<String> tp = new ArrayList<>();
        tp.add("Crédito");
        tp.add("Débito");
        tp.add("Boleto");
        cbTipoPagamento.setItems(FXCollections.observableArrayList(tp));
        
        cbMarca.setItems(FXCollections.observableArrayList(new DALMarca().get("")));
        cbTipo.setItems(FXCollections.observableArrayList(new DALTipo().get("")));
        cbMedida.setItems(FXCollections.observableArrayList(new DALMedida().get("")));
        cbRecipiente.setItems(FXCollections.observableArrayList(new DALRecepiente().get("")));
        cbCliente.setItems(FXCollections.observableArrayList(new DALCliente().get("")));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarCBs();
    }    

    @FXML
    private void clkMinimiar(ActionEvent event) {
        ((Stage)(btMinizar.getParent().getScene().getWindow())).setIconified(true);
    }

    @FXML
    private void clkFechar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLTelaFavorito.fxml"));
            bpPrincipal.setCenter(root);
        }
        catch(IOException exc) {System.out.println(exc);}
    }

    @FXML
    private void clkMarca(ActionEvent event) {
        
    }

    @FXML
    private void clkTipo(ActionEvent event) {
    }

    @FXML
    private void clkMedida(ActionEvent event) {
    }

    @FXML
    private void clkRecipiente(ActionEvent event) {
    }

    @FXML
    private void clkCliente(ActionEvent event) {
    }

    @FXML
    private void clkInserir(ActionEvent event) {
    }

    @FXML
    private void clkRemover(ActionEvent event) {
    }

    @FXML
    private void clkLimpar(ActionEvent event) {
    }

    @FXML
    private void clkComprar(ActionEvent event) {
    }

    
}
