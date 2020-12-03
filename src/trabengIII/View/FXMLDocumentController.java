package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private JFXComboBox<?> cbMarca;
    @FXML
    private JFXComboBox<?> cbTipo;
    @FXML
    private JFXComboBox<?> cbMedida;
    @FXML
    private JFXComboBox<?> cbRecipiente;
    @FXML
    private JFXComboBox<?> cbCliente;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btRemover;
    @FXML
    private TableView<?> tvLeite;
    @FXML
    private JFXComboBox<?> cbTipoPagamento;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private JFXButton btComprar;
    private VBox vbPrincipal;
    @FXML
    private BorderPane bpPrincipal;
    
    
    public static BorderPane bpprin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bpprin = bpPrincipal;
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
